### What is a dsl?

A *Domain Specific Language* is a highly specialized computer language.  A DSL can make it easier to express intent and you are probably familiar with a few.

Gradle build scripts have their own dsl.  For example, when configuring repositories:

```kotlin
repositories {
    jcenter()
}

```

The code here says "use the jcenter repository when resolving dependencies".  It gives no
hints to its implementation, it is a bit like a flexible configuration, but of course you can
 write arbitrary kotlin alongside the dsl.
 
The [Kotlinx library](https://github.com/Kotlin/kotlinx.html) allows you to build html from kotlin using a dsl, which I think looks like html implemented in kotlin.
```kotlin
System.out.appendHTML().html {
    body {
        div {
            a("https://kotlinlang.org") {
                target = ATarget.blank
                +"Main site"
            }
        }
    }
}
```

This code clearly describes an html document, but it provides the advantage of being able to construct the html from kotlin, which 
is completely type safe.  The library even scopes where you can introduce tags, for example trying to put a `tr` tag 
anywhere but insidde of a `table` tag will result in a compilation error.  In this way, the kotlin dsl not only causes the
resulting code to express functionality at a high level, it also makes it easier to write thanks to compile time checks which are
exposed through an IDE.

(As an aside, the majority of ktor is generated;  I will not be getting into generating a dsl from configuration in this blog)

### Our DSL

Jenkins exposes a dsl for describing builds via the Pipeline DSL, which is often referred to coloquially as "Jenkinsfiles".
The [Pipeline DSL](https://jenkins.io/doc/book/pipeline/syntax/) is implemented in groovy.

A simple example from the documentation is as follows:

```groovy
pipeline {
    agent { docker 'maven:3-alpine' } 
    stages {
        stage('Example Build') {
            steps {
                sh 'mvn -B clean verify'
            }
        }
    }
}
```

Jenkinsfiles impose a few limitations upon users:
1. Shared pipeline immplementation (via library) is limited as stages cannot be created in a loop and must be literals
2. Many basic language features require additional configuration (String functions require security configuraiton) or
must be run in a special context (collection functions don't work in Jenkinsfiles, and need to be in methods that run outside of the CPS context)
3. Code sharing is cumbersome at best

By generating Jenkinsfiles with a kotlin dsl, we can get around some of these issues.

```kotlin
pipeline {
    agent { docker("maven:3-alpine") }
    stages {
        stage("Example Build") {
            steps {
                sh("mvn -B clean verify")
            }
        }
    }
}
```

The kotlin dsl looks nearly identical to the groovy dsl in this example. The only tangible difference in this example is the strings must have
double quotes rather than single quotes due to the kotlin language interpreting single quotes as characters.

We must  impose a few  limitations on the dsl. Namely, dsl functions must be scoped to specific contexts, steps must only be invokable from inside a `steps` block and agents should only be invokable in an `agent` block. This can  be achieved with extension functions.

The designs discussed in the rest of this section are implented in the [`dsl`](https://github.com/code42/pipelinekt/blob/d732295afb0328b0675f98e2f2c81076ddba4614/dsl) subproject.

### The Pipeline

Consider the interface for the pipeline method:


```kotlin
fun pipeline(pipelineBlock: PipelineContext.() -> Unit): Pipeline
```

This function takes in a function and returns a `Pipeline` object, that represents the pipeline to generate.

```kotlin
data class Pipeline(val agent: Agent?, val stages: List<Stage>, val post: Post?)
```

The Pipeline object represents the components of a pipeline, and is created through the `PipelineContext`

`PipelineContext` exposes methodds for  building `agent`, `stage` and `post` blocks.  The implementation is removed here for the sake of brevity.

```kotlin
interface PipelineContext {
    fun stages(stagesBlock: TopLevelStageContext.() -> Unit)
    fun agent(agentBlock: AgentContext.() -> Unit)
    fun post(postBlocck: PostContext.() -> Unit) 
}

```

The `pipeline` method combined withe the `PipelineContext` class allows us to write the following:

```kotlin
pipeline {
    agent { }
    stages { }
    post { }
}
```

### Stages

The stages are a bit more complex than the Pipeline itself.  They have several forms and the rules are as follows:
1. Stages can contain steps, a list of stages to be run in sequence, or a list of stages to be run in parallel
2. each stage has optional code blocks such as `agent` and `post`
3. stages can only execute  in parallel at the top level (no nested parallelism)

In the groovy dsl, the stages block has calls to `stage(String) { ... }`, so `TopLevelStageContext` (the scope for the `stages` block on the `PipelineContext` class) should implement a similar method:


```kotlin
interface PipelineContext {
    fun stages(stagesBlock: StageWrapperContext.() -> Unit)
}
```

And we can define a similar  interface for `StepStageContext` by following the same process:

```kotlin
interface StageWrapperContext {
    fun stage(name: String, stageBlock: StageContext.() -> Unit)
}

interface StageContext {
    fun steps(stepBlock: DslContext<Step>.() -> Unit)
    fun agent(agentBlock: AgentContext.() -> Unit)
    fun post(postBlock: PostContext.() -> Unit)
}
```

Now our dsl looks like this:

```kotlin
pipeline {
    agent { }
    stages {
        stage("Build") {
            agent { }
            steps { }
            post { }
        }
     }
    post { }
}
```

Any of the blocks are optional in our dsl, and won't produce a compile time error.  This could be simplified to:

```kotlin
pipeline {
    agent { }
    stages {
        stage("Build") {
            steps { }
        }
     }
    post { }
}
```

We'll come back to parallel and sequential stages.  For now, it is more interesting to talk about the `steps`.

### Steps

Continueing on down the chain, we now have to implement the `StepContext`.  Jenkins has a lot of steps.  There are some  common  ones such as `sh`, `cleanWs`, `echo`, `withEnv`, `withCredentials` and more.  There are even more that are seen in seldom installed plugins.  Every user will have different steps available, and there will be a lot of them.  Defining them in one class would be a bit heavy handed.

Luckily, kotlin provides an amazing tool for extending classes on the fly that allows us to implement steps on an ad hoc basis.

Above the `StepContext` interface referenced in the `stage` method. For now, we just need an empty interface:
```
interface StepContext {
    add(step: Step)
}
```

Now we can implement our steps:

```

fun DslContext<Step>.sh(script: String) {
    this.add(Sh(script))
}

fun DslContext<Step>.cleanWs(skipWhenFailed: Boolean = false) {
    this.add(CleanWs(skipWhenFailed))
}
```

For now, the `Sh` and `Step` classes are just simple data classes:

```kotlin
interface Step
data class Sh(val script: String): Step
data class CleanWs(val skipWhenFailed: Boolean = false): Step
```

Here we have defined an extension method on `StepContext`, so when you invoke  `fun steps(stepBlock: DslContext<Step>.() -> Unit)` on `StepStageContext`, you can call the `sh` and `cleanWs` methodds.


```kotlin
pipeline {
    agent { }
    stages {
        stage("Build") {
            steps { 
                sh("./build.sh")
            }
        }
     }
    post { }
}
```

# Conclusion

These are the basic strategies for implementing a DSL interface. Following the methods described here, we can continue to extend our dsl to include more steps, and also to implement other parts of the jenkinsfile dsl (such as the the various blocks found in the `pipeline` block.  

However, we still need to implement the dsl and will tackle that in the next section.
