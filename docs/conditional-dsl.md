## Conditional DSL

Pipeline kt provides a dsl for building conditional logic into jenkinsfiles.  This supports both `when` blocks in
the pipeline dsl and inline `if` and compisition of
boolean statements through the [Boolean Statement DSL](https://github.com/code42/pipelinekt/blob/d732295afb0328b0675f98e2f2c81076ddba4614/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/conditional/BooleanStatementDsl.kt) 
as well as string comparisons through the [String Comparison Dsl](https://github.com/code42/pipelinekt/blob/d732295afb0328b0675f98e2f2c81076ddba4614/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/conditional/StringComparisonDsl.kt)

For example, in a when block you can determine to run a stage based on whether a parameter is truthy:
```kotlin
stage("Native Test") {
    `when` { expression { "DO_NATIVE_TEST".parameter().statement() }}
    ...
}
```

You can also inline if statements based on the output of previous steps, parameters, and environment variables like so:

```kotlin
val isRelease = def { sh(script = "./isRelease.sh", returnStdout = true) }
`if`((isRelease `==` "true") `||` "DO_RELEASE".parameter(),
        `then` = {
            sh("./publishRelease.sh")
        },
        `else` = {
            sh("./publishSnapshot.sh")
        })
```


And putting it all together:

```kotlin
fun PipelineDsl.conditionalPipeline() = pipeline {
    stages {
        stage("Build") {
            `when` { expression { "DO_BUILD".parameter().statement() }}
            steps {
                sh("./build.sh")

                val isRelease = def { sh(script = "./isRelease.sh", returnStdout = true) }
                `if`((isRelease `==` "true") `||` "DO_RELEASE".parameter(),
                        `then` = {
                            sh("./publishRelease.sh")
                        },
                        `else` = {
                            sh("./publishSnapshot.sh")
                        })
            }
        }
    }
}
```

## Can't I just use the native Kotlin if statement?

Yes, you can.  You can even access the values of parameters and environmentvariables via the java runtime in your kotlin code.

However, there is a bit of nuance and risk to this approach.

Using the above example:

```kotlin
val isRelease = def { sh(script = "./isRelease.sh", returnStdout = true) }
`if`((isRelease `==` "true") `||` "DO_RELEASE".parameter(),
        `then` = {
            sh("./publishRelease.sh")
        },
        `else` = {
            sh("./publishSnapshot.sh")
        })
```

will generate groovy like:

```groovy
script {
    def iSRElEaSeVariable
    iSRElEaSeVariable =
      sh (script: "./isRelease.sh", returnStdout: true)
    if(((iSRElEaSeVariable) == ("true")) || (params.DO_RELEASE)) {
      sh (script: "./publishRelease.sh", returnStdout: false)
    }
    else {
      sh (script: "./publishSnapshot.sh", returnStdout: false)
    }
  }
```

On the other hand, code that uses the native kotlin if statement:

```kotlin
val isRelease = true
if(isRelease || !System.getenv("DO_RELEASE").isNullOrBlank()) {
    sh("./publishRelease.sh")
} else {
    sh("./publishSnapshot.sh")
}
```

will generate EITHER

    `sh (script: "./publishRelease.sh", returnStdout: false)`

or

    `sh (script: "./publishSnapshot.sh", returnStdout: false)`

depending on the evaluation at pipeline generation time.

There is a significant tradeoff to the second approach that may be acceptable in some use cases.  
* In the first example, with the dsl `if` statement, the script will evaluate the output of `isRelease` At *pipeline runtime*.
* in the second example, with the native kotlin if statement, the script will evaluate the value of `isRelease` and the `DO_RELEASE` environment variable during *pipeline generation*