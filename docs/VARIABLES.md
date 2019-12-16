## Using Built in Variables

The `Var.Variable` type represents a variable in groovy.  From pipeline kt you can interpolate a `Var.Variable` into a string and it will generated interpolated groovy, for example:

```kotlin
val workspace = "workspace".groovyVariable()
sh("ls $workspace")
```

will generate the groovy:

```groovy
sh (script: "ls ${workspace}", returnStdout: false)
```

## Accessing Environment Variables and Parameters

You can get an environment variable by calling the `String.environmentVar()` method and a parameter by calling `String.parameter()`.

These will be objects of type `Var.Variable`.  `Var` objects can be interpolated into Strings.

```kotlin
val myEnvVar = "SOME_ENVIRONMENT_VARIABLE".environmentVar()
val myParameter = "MY_PARAMETER".parameter()
sh("./build ${myEnvVar} ${myParameter}")
```

this would generate the following groovy:

```groovy
sh (script: "./build ${env.SOME_ENVIRONMENT_VARIABLE} ${params.MY_PARAMETER}", returnStdout: false)
```

## Declaring Variables

Maybe you want to declare a variable, say if you want to capture the output of `sh` or `readproperties`

```kotlin
val currentPath = def { sh("pwd", true) }
```

Which will generate something like:

```groovy
def rAnDomVariablenAmE = sh (script: "pwd", returnStdout: true) //rAnDomVariablenAmE is psuedo code and the name will be random
```

## Reassigning existing variables

You can also reassign existing variables with the `assign` function

```kotlin
//literal is a step that interpolates literal strings into the jenkinsfile
val currentBuildVar = assign("currentBuild.result") { literal("currentBuild.result ?: 'SUCCESS'") }
```

which generates

```groovy
currentBuild.result = currentBuild.result ?: 'SUCCESS'
```
