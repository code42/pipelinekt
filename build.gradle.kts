import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL
import com.code42.version.Version

val kotlinVersion = "1.9.22"

plugins {
    base
    kotlin("jvm") version "1.9.22"
    id("idea")
    // maven plugin removed (invalid here)
    `maven-publish`
    // Spotless plugin disabled
    id("org.jetbrains.dokka").version("1.9.0")
    id("io.gitlab.arturbosch.detekt").version("1.23.0")
    jacoco
}
val githubRepo = System.getenv("GITHUB_REPOSITORY") ?: "code42/pipelinekt"
val groupName = "com.code42.jenkins"
val baseProjectName = "pipelinekt"
val publishedProjects = listOf("core", "internal", "dsl")

allprojects {
    group = "com.code42"
    version = Version.getVersion()

    repositories {
        mavenCentral()
    }
}

tasks.named<DokkaTask>("dokkaGfm") {
    outputDirectory.set(file("${project.rootDir}/docs/dokka"))
    dokkaSourceSets {
        named("main") {
            sourceLink {
                localDirectory.set(file("./"))
                remoteUrl.set(java.net.URI("https://github.com/$githubRepo/tree/master").toURL())
                remoteLineSuffix.set("#L")
            }
        }
    }
}

tasks {
    register("incrementVersion") {
        doLast {
            Version.incrementVersion()
        }
    }
}

tasks.build {
    finalizedBy("dokkaGfm")
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        implementation(kotlin("stdlib-jdk8", kotlinVersion))
        implementation(kotlin("reflect", kotlinVersion))
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "21"
        }
    }

    if (publishedProjects.contains(project.name)) {
    apply(plugin = "org.gradle.maven-publish")
    // Spotless fully disabled
        apply(plugin = "io.gitlab.arturbosch.detekt")
        apply(plugin = "org.gradle.jacoco")
        apply(plugin = "org.jetbrains.dokka")

        val sourcesJar by tasks.registering(Jar::class) {
            archiveClassifier.set("sources")
            from(sourceSets.main.get().allSource)
        }

        jacoco {
            toolVersion = "0.8.10"
        }

        artifacts {
            add("archives", sourcesJar.get())
        }

        tasks.withType<JacocoReport> {
            reports {
                xml.required.set(false)
                csv.required.set(false)
                html.required.set(true)
                html.outputLocation.set(file("$buildDir/reports/coverage"))
            }
        }

        tasks.build {
            finalizedBy("jacocoTestReport")
        }

        // spotless {
        //     kotlin {
        //         ktlint()
        //     }
        //     kotlinGradle {
        //         target("*.gradle.kts'", "additionalScripts/*.gradle.kts")
        //         ktlint()
        //     }
        // }

        detekt {
            source.setFrom(files("src/main/kotlin", "src/test/kotlin"))
            baseline = file("detekt-${project.name}-baseline.xml") // Just if you want to create a baseline file.
        }

        tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
            exclude(".*/resources/.*,.*/build/.*")
            jvmTarget = "21"
        }

        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = group.toString()
                    version = project.version.toString()
                    artifactId = "pipelinekt-${project.name}"
                    from(components["java"])
                    artifact(sourcesJar.get())
                }
            }
            repositories {
                mavenLocal()
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/$githubRepo")
                    val token = System.getenv("GITHUB_TOKEN")
                    if (token != null) {
                        credentials(HttpHeaderCredentials::class) {
                            name = "Authorization"
                            value = "Bearer ${token}"
                        }
                        authentication {
                            create<HttpHeaderAuthentication>("header")
                        }
                    } else {
                        credentials {
                            username = System.getProperty("github.packages.username") ?: System.getenv("GITHUBUSER")
                            password = System.getProperty("github.packages.token") ?: System.getenv("GITHUBTOKEN")
                        }
                    }
                }
            }
        }
    }
}


