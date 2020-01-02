
Please see [the examples subproject](https://github.com/code42/pipelinekt/tree/master/examples) project. It contains working examples of generating pipelines.

# Project setup

Pipelinekt is made to integrate with gradle, so it can run anywhere that the jvm exists without additional infrastructure needed for dependency management or having
to rely on loading new classes into the jenkins runtime.

0. create a github access token that can read from packages, add the configuration to `~/.gradle/gradle.properties`

```
systemProp.github.packages.username=yourusername
systemProp.github.packages.token=yourtoken
```

1. create a gradle project in a subdirectory called `ci` in your git repo. The project should be an application with a gradle run task.
    * Add a dependency on pipelinekt-code42

    * ci/build.gradle.kts

    ```kotlin
    val kotlinVersion = "1.3.60"
    val version = "0.11.1"
 
    plugins {
        id("org.jetbrains.kotlin.jvm").version("1.3.60")
        maven
        application
    }
    repositories {
         maven {
            name = "Github Packages"
            url = uri("https://maven.pkg.github.com/code42/pipelinekt")
            //Use github token if it is available (used in github actions)
            //otherwise fall back to system properties or environment variables
            val token = System.getenv("GITHUB_TOKEN")
            if(token != null) {
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

    application {
        mainClassName = "your.main.package.MainKt"
    }

    dependencies {
        implementation("com.code42.jenkins:pipelinekt-dsl:$version")
        implementation(kotlin("stdlib-jdk8", kotlinVersion))
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.jetbrains.kotlin:kotlintest-junit")
    }
    ```


2. create a main method that generates a pipeline (see below)
    
3. begin iterating on your pipeline!
    1. generate it locally via gradle if you want to validate: `./gradlew run` from the `ci/` directory
    
# Generating a simple pipeline

The minimum code to create and generate a simple pipeline:

`ci/src/main/kotlin/your/main/package/Main.kt`:

```kotlin
import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.step.declarative.echo
import com.code42.jenkins.pipelinekt.core.generatePipeline

fun main () {
    val pipelineDsl = PipelineDsl()
    
    val myPipeline = pipelineDsl.pipeline {    
        agent {
            label("linux")
        }
        stages {
            stage("Build") {
                steps {
                    echo("Hello, World!")
                }
            }
        }
    }
    
    generatePipeline(myPipeline, "path/to/Jenkinsfile.generated")
}

```

This will output a Jenkinsfile into at the file `path/to/Jenkinsfile.generated`

You can actually invoke this from a Jenkinsfile, and then write all of your pipeline code in kotlin except for the base. 
Assuming you have a subdirectory called `ci` that contains a gradle project that runs the generation code, you can do
something like the following:

`Jenkinsfile`:

```groovy
node('my-gradle-node') {
    checkout scm
    echo "Generating Jenkinsfile"
    dir("ci") {
        sh "./gradlew run"
    }
    unstash("generated-ci")
    load("${env.WORKSPACE}/path/to/Jenkinsfile.generated")
}
```

# Configuration

The `PipelineDsl` class has configuration for lots of shared steps, for example `beforeLocalStage` and `afterLocalStage`
are injected.  These can be injected at creation time. For example:

```kotlin
val pipelineDsl = PipelineDsl(
        defaultAgent = {
            label("linux")
        },
        beforeLocalStage = {
            echo("Hello, I am a stage and I am running on '${"NODE_NAME".environmentVar()}', which I have inherited from the parent context")
        },
        beforeRemoteStage = {
            echo("Hello, I am a stage and I am running on '${"NODE_NAME".environmentVar()}")
        }
)

val myConfiguredPipeline = pipelineDsl.pipeline {
    // inherits default agent
    stages {
        stage("Build") {
            //injects beforeLocalStageSteps
            steps {
                sh("./build.sh")
            }
        }
        stage("Validation") {
            parallel {
                stage("Unit Test") {
                    steps {
                        //injects beforeLocalStageSteps
                        sh("./unitTest.sh")
                    }
                }
                stage("Integration Test") {
                    agent(defaultAgent)
                    steps {
                        //injects beforeRemoteStageSteps
                        sh("./integrationTest.sh")
                    }
                }

                stage("Acceptance") {
                    agent {
                        label("acceptance && linux")
                    }

                    steps {
                        //injects beforeRemoteStageSteps
                        sh("./acceptanceTest.sh")
                    }
                }
            }
        }
    }
}
```
