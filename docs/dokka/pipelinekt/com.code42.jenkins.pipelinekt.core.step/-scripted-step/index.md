[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.step](../index.md) / [ScriptedStep](./index.md)

# ScriptedStep

`interface ScriptedStep : `[`Step`](../-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/step/ScriptedStep.kt#L8)

Ensure that the pipeline is in ScriptedStep context.  These steps will not be run in the declarative context.

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `abstract fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toGroovy](to-groovy.md) | `open fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Docker](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-docker/index.md) | `sealed class Docker : `[`ScriptedStep`](./index.md) |
| [If](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-if/index.md) | `data class If : `[`ScriptedStep`](./index.md)`, `[`NestedStep`](../-nested-step/index.md) |
| [Literal](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-literal/index.md) | Define arbitrary scripted Jenkinsfile code blocks`data class Literal : `[`ScriptedStep`](./index.md)`, `[`SingletonStep`](../-singleton-step/index.md) |
| [Node](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-node/index.md) | You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel`data class Node : `[`ScriptedStep`](./index.md)`, `[`NestedStep`](../-nested-step/index.md) |
| [NotifyBitbucket](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-notify-bitbucket/index.md) | Notify Bitbucket server of build status.  Use at the beginning and end of a pipeline.`object NotifyBitbucket : `[`ScriptedStep`](./index.md)`, `[`SingletonStep`](../-singleton-step/index.md) |
| [ReadProperties](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-read-properties/index.md) | `data class ReadProperties : `[`ScriptedStep`](./index.md)`, `[`SingletonStep`](../-singleton-step/index.md) |
| [ScriptedParallel](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-scripted-parallel/index.md) | This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.`data class ScriptedParallel : `[`ScriptedStep`](./index.md)`, `[`Step`](../-step/index.md) |
| [VariableAssignment](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-variable-assignment/index.md) | Declare a variable and assign it to the output of some steps`data class VariableAssignment : `[`ScriptedStep`](./index.md)`, `[`NestedStep`](../-nested-step/index.md) |
