import org.jetbrains.dokka.gradle.DokkaTask

val kotlinVersion = "1.3.61"

plugins {
    base
    kotlin("jvm") version "1.3.21"
    id("idea")
    maven
    id("com.diffplug.gradle.spotless").version("3.26.1")
    id("org.jetbrains.dokka").version("0.10.0")
    id("io.gitlab.arturbosch.detekt").version("1.2.2")
    jacoco
    id("org.shipkit.java").version("2.2.5")
}

val groupName = "com.code42.jenkins"
val baseProjectName = "pipelinekt"
val publishedProjects = listOf("core", "internal", "dsl")

allprojects {
    group = "com.code42.lib.jenkins"

    repositories {
        mavenCentral()
        jcenter()
    }
}

val dokka by tasks.getting(DokkaTask::class) {
    outputFormat = "gfm"
    outputDirectory = "${project.rootDir}/docs/dokka"
    configuration {
        sourceLink {
            path = "./"
            url = "https://github.com/code42/pipelinekt/tree/master"
            lineSuffix = "#L"
        }

        subProjects = publishedProjects
    }


}

tasks.build {
    finalizedBy("dokka")
}

subprojects {
    apply(plugin = "org.gradle.maven")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(kotlin("stdlib-jdk8", kotlinVersion))
        implementation(kotlin("reflect", kotlinVersion))
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation( "org.jetbrains.kotlin:kotlin-test-junit")
    }





    if(publishedProjects.contains(project.name)) {
        apply(plugin = "com.diffplug.gradle.spotless")
        apply(plugin = "io.gitlab.arturbosch.detekt")
        apply(plugin = "org.gradle.jacoco")


        tasks.withType<JacocoReport> {
            reports {
                xml.isEnabled = false
                csv.isEnabled = false
                html.isEnabled = true
                html.destination = file("$buildDir/reports/coverage")
            }
        }

        tasks.build {
            finalizedBy("jacocoTestReport")
        }

        spotless {
            kotlin {
                ktlint()
            }
            kotlinGradle {

                target("*.gradle.kts'", "additionalScripts/*.gradle.kts")

                ktlint()
            }
        }

        detekt {
            input = files("src/main/kotlin", "src/test/kotlin")
            baseline = file("detekt-${project.name}-baseline.xml") // Just if you want to create a baseline file.
        }

        tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
            exclude(".*/resources/.*,.*/build/.*")
        }
    }
}

