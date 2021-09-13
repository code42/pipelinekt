# Extending

## Adding Steps

### Extending The Step Class

*This section also applies to `Agent`, `Option`, `Trigger`, `Tool`, `Parameter`, `Trigger`, and `When`, 
but the implementation for those is a little bit simpler*


When implementing a step, there are two pieces of work you have to do:
1. create a class that extends `com.code42.jenkins.pipelinekt.core.step.Step`
    * You can and should combine
        * `com.code42.jenkins.pipelinekt.core.step.SingletonStep` or `com.code42.jenkins.pipelinekt.core.step.NestedStep`
        * with one of `com.code42.jenkins.pipelinekt.core.step.DeclarativeStep` or `com.code42.jenkins.pipelinekt.core.step.ScriptedStep`
    * for example:
    ```kotlin
    data class MyNewStep(...) : SingletonStep, DeclarativeStep
    //or
    data class MyStepWithANestedStep(..., override val steps: Step): NestedStep, DeclarativeStep
    ```
    * `SingletonStep` is for steps that don't contain more steps like `sh` or `stash`
    * `NestedStep` is for steps contain other steps, like `withCredentials` or `withEnv` or `node`
    * `DeclarativeStep` and `ScriptedStep` are for determining whether a step runs inside of the declarative or scripted context.
        * some steps do not support the declarative jenkinsfile context
        * [See the documentation](https://jenkins.io/doc/book/pipeline/#declarative-versus-scripted-pipeline-syntax)
        * `ScriptedStep` can be used to implement custom code blocks as steps
    * if extending `DeclarativeStep` implement `toGroovy`, if extending `ScriptedStep` implement `scriptedGroovy`   
    * If adding to pipelinekt, add to the `internal` module, otherwise just put it in your project somewhere 
        * These are not meant to be exposed to end users.  End users should exclusively use the `dsl`.  the `dsl` module
          will not expose classes from `internal` to users.

2. Implementing a DSL method
    * Create the dsl methods
    
        * simple example
        ```kotlin
        fun DslContext<Step>.myNewStep(...) { add(MyNewStep(...)) }
        fun DslContext<Step>.myStepWithANestedStep(..., steps: DslContext<Step>.() -> Unit) { add(MyStepWithANestedStep(..., DslContext.into(steps).toStep())) }
  
        ```
        
This would expose a new step that can be used anywhere you can use a step, for example:

```kotlin
stage("my stage") {
    steps {
        myNewStep(args...)
        myStepWithANestedStep(args...) {
            sh("env")
        }
    }
}
```
See the existing examples:
  * The class `com.code42.jenkins.pipelinekt.internal.step.Sh` is a good example of a simple step - it is a data class that can serialize itself to groovy
  * `com.code42.jenkins.pipelinekt.internal.step.WithCredentials` is a simple example of a nested step

## Adding complex functionality

The library also allows you to implement complex steps that may take in configuration.  A good example of this is the
[`gradle build dsl`](https://github.com/code42/pipelinekt/blob/d732295afb0328b0675f98e2f2c81076ddba4614/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/custom/GradleBuildDsl.kt) and the [`docker dsl`](https://github.com/code42/pipelinekt/blob/d732295afb0328b0675f98e2f2c81076ddba4614/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/custom/DockerDsl.kt)

Lets take a look at part of the gradle build dsl:

```kotlin
data class GradleBuildDsl(
    val gradleCredentials: UsernamePassword? = null,
    val gradleUserProperty: String = "gradle.wrapperUser",
    val gradlePasswordProperty: String = "gradle.wrapperPassword"
) {
    ...
    fun DslContext<Step>.gradleCommand(command: String, additionalBuildArgs: Var.Literal.Str) =
            withEnv(
                mapOf("GRADLE_USER_HOME" to "${"WORKSPACE".environmentVar()}/.gradle-home-tmp",
                "JENKINS_NODE_COOKIE" to "dontKillMe")
            ) { artifactoryAuthenticated {
                sh(("./gradlew --stacktrace --build-cache " +
                        (gradleCredentials?.let { "-D$gradleUserProperty=\\\"\\\${${it.usernameVariable.value}}\\\" -D$gradlePasswordProperty=\\\"\\\${${it.passwordVariable.value}}\\\" " } ?: "") +
                        "$additionalBuildArgs $command").strDouble())
            } }
    ...
```

Gradle build defines a public method that is an extension method, but we can't call this method with just the dsl,
however we can run this method inside of our dsk script if we wrap it with a call to `gradleBuildDsl.run { ... }`:

```kotlin
val gradle = GradleBuildDsl()
/**
 * Pipeline
 */
fun PipelineDsl.gradleBuildPipeline() =
        gradle.run {
            pipeline {
                stages {
                    stage("Build") {
                        steps {
                            gradleCommand("build $gradleArgs")
                        }
                    }
                    stage("Publish") {
                        steps {
                            gradleCommand("publish $gradleArgs")
                        }
                    }
                }
            }
        }
```

By wrapping the pipeline in `gradle.run`, the method gradleCommand is exposed on DslContext<Step>, which means that 
the `gradleCommand` method now behaves like a custom step.

This gives the benefit of being able to inject some configuration into the dsl, for gradle the configuration is a
credentialsId and username/password properties.  This prevents users from having to repeat the same rather verbose
sh calls all over our pipelines and allows us to build pipelines where we can easily swap out credentials.
