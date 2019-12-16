[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.writer](../index.md) / [GroovyScript](./index.md)

# GroovyScript

`interface GroovyScript` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/writer/GroovyWriter.kt#L10)

A class that can be mapped to a jenkinsfile

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(writer: `[`GroovyWriter`](../-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Agent](../../com.code42.jenkins.pipelinekt.core/-agent.md) | `interface Agent : `[`GroovyScript`](./index.md) |
| [ExcludeAxis](../../com.code42.jenkins.pipelinekt.core.stage/-exclude-axis/index.md) | `sealed class ExcludeAxis : `[`GroovyScript`](./index.md) |
| [MatrixAxis](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-axis/index.md) | `data class MatrixAxis : `[`GroovyScript`](./index.md) |
| [MatrixBody](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-body/index.md) | `data class MatrixBody : `[`GroovyScript`](./index.md) |
| [MatrixExclude](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-exclude/index.md) | `data class MatrixExclude : `[`GroovyScript`](./index.md) |
| [Option](../../com.code42.jenkins.pipelinekt.core/-option.md) | `interface Option : `[`GroovyScript`](./index.md) |
| [Parameter](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) | `interface Parameter : `[`GroovyScript`](./index.md) |
| [Pipeline](../../com.code42.jenkins.pipelinekt.core/-pipeline/index.md) | `data class Pipeline : `[`GroovyScript`](./index.md) |
| [PipelineMethod](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md) | `data class PipelineMethod : `[`GroovyScript`](./index.md) |
| [Post](../../com.code42.jenkins.pipelinekt.core/-post/index.md) | `data class Post : `[`GroovyScript`](./index.md) |
| [Stage](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md) | A declarative Jenkinsfile Stage`sealed class Stage : `[`GroovyScript`](./index.md) |
| [Step](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) | `interface Step : `[`GroovyScript`](./index.md) |
| [Tool](../../com.code42.jenkins.pipelinekt.core/-tool.md) | `interface Tool : `[`GroovyScript`](./index.md) |
| [Trigger](../../com.code42.jenkins.pipelinekt.core/-trigger.md) | `interface Trigger : `[`GroovyScript`](./index.md) |
| [When](../../com.code42.jenkins.pipelinekt.core/-when.md) | `interface When : `[`GroovyScript`](./index.md) |
