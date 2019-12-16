[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core](../index.md) / [Pipeline](./index.md)

# Pipeline

`data class Pipeline : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/Pipeline.kt#L17)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Pipeline(agent: `[`Agent`](../-agent.md)`? = null, tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../-tool.md)`> = emptyList(), options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Option`](../-option.md)`> = emptyList(), triggers: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Trigger`](../-trigger.md)`> = emptyList(), parameters: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Parameter`](../-parameter/index.md)`> = emptyList(), stages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`> = emptyList(), methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`> = emptyList(), post: `[`Post`](../-post/index.md)` = Post())` |

### Properties

| Name | Summary |
|---|---|
| [agent](agent.md) | `val agent: `[`Agent`](../-agent.md)`?` |
| [methods](methods.md) | `val methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`>` |
| [options](options.md) | `val options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Option`](../-option.md)`>` |
| [parameters](parameters.md) | `val parameters: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Parameter`](../-parameter/index.md)`>` |
| [post](post.md) | `val post: `[`Post`](../-post/index.md) |
| [stages](stages.md) | `val stages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`>` |
| [tools](tools.md) | `val tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../-tool.md)`>` |
| [triggers](triggers.md) | `val triggers: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Trigger`](../-trigger.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
