[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl](../index.md) / [PipelineDsl](./index.md)

# PipelineDsl

`data class PipelineDsl : `[`MethodDsl`](../../com.code42.jenkins.pipelinekt.dsl.method/-method-dsl/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/PipelineDsl.kt#L36)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PipelineDsl(defaultBuildOptions: `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {
    buildDiscarder(logRotator(10, 10, 10, 10))
    ansiColor("xterm")
    timestamps()
    disableConcurrentBuilds()
}, beforePrepSteps: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterPrepSteps: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, beforeLocalStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterLocalStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, beforeRemoteStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterRemoteStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, beforePipelinePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterPipelinePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {
    cleanup {
        cleanWs()
    }
}, beforeLocalStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterLocalStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, beforeRemoteStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, afterRemoteStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {
      cleanup {
          cleanWs()
      }
}, remoteStageOptions: `[`DslContext`](../-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, defaultAgent: `[`SingletonDslContext`](../-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, pipelineMethodRegistry: `[`PipelineMethodRegistry`](../../com.code42.jenkins.pipelinekt.dsl.method/-pipeline-method-registry/index.md)` = PipelineMethodRegistry(), stages: `[`Deque`](https://docs.oracle.com/javase/6/docs/api/java/util/Deque.html)`<`[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`> = LinkedBlockingDeque())` |

### Properties

| Name | Summary |
|---|---|
| [afterLocalStage](after-local-stage.md) | `val afterLocalStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterLocalStagePost](after-local-stage-post.md) | `val afterLocalStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterPipelinePost](after-pipeline-post.md) | `val afterPipelinePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterPrepSteps](after-prep-steps.md) | `val afterPrepSteps: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterRemoteStage](after-remote-stage.md) | `val afterRemoteStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterRemoteStagePost](after-remote-stage-post.md) | `val afterRemoteStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforeLocalStage](before-local-stage.md) | `val beforeLocalStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforeLocalStagePost](before-local-stage-post.md) | `val beforeLocalStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforePipelinePost](before-pipeline-post.md) | `val beforePipelinePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforePrepSteps](before-prep-steps.md) | `val beforePrepSteps: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforeRemoteStage](before-remote-stage.md) | `val beforeRemoteStage: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforeRemoteStagePost](before-remote-stage-post.md) | `val beforeRemoteStagePost: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultAgent](default-agent.md) | `val defaultAgent: `[`SingletonDslContext`](../-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultBuildOptions](default-build-options.md) | `val defaultBuildOptions: `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pipelineMethodRegistry](pipeline-method-registry.md) | `val pipelineMethodRegistry: `[`PipelineMethodRegistry`](../../com.code42.jenkins.pipelinekt.dsl.method/-pipeline-method-registry/index.md) |
| [remoteStageOptions](remote-stage-options.md) | `val remoteStageOptions: `[`DslContext`](../-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stages](stages.md) | `val stages: `[`Deque`](https://docs.oracle.com/javase/6/docs/api/java/util/Deque.html)`<`[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [afterPipelinePost](after-pipeline-post.md) | `fun `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.afterPipelinePost(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [afterPrepSteps](after-prep-steps.md) | `fun `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.afterPrepSteps(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforePipelinePost](before-pipeline-post.md) | `fun `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.beforePipelinePost(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [beforePrepSteps](before-prep-steps.md) | `fun `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.beforePrepSteps(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultBuildOptions](default-build-options.md) | `fun `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`>.defaultBuildOptions(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pipeline](pipeline.md) | `fun pipeline(prepSteps: `[`DslContext`](../-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = { }, pipelineBlock: `[`PipelineContext`](../-pipeline-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Pipeline`](../../com.code42.jenkins.pipelinekt.core/-pipeline/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [withConfigurationContext](../with-configuration-context.md) | `fun <T, Dsl : `[`MethodDsl`](../../com.code42.jenkins.pipelinekt.dsl.method/-method-dsl/index.md)`> Dsl.withConfigurationContext(applyConfiguration: Dsl.() -> Dsl, stage: Dsl.() -> T): T` |
