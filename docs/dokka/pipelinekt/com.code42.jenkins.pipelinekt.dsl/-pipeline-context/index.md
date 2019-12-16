[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl](../index.md) / [PipelineContext](./index.md)

# PipelineContext

`data class PipelineContext` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/PipelineContext.kt#L13)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PipelineContext(agentContext: `[`SingletonDslContext`](../-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`> = SingletonDslContext(), triggersContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Trigger`](../../com.code42.jenkins.pipelinekt.core/-trigger.md)`> = DslContext(), parametersContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md)`> = DslContext(), toolContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = DslContext(), optionContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`> = DslContext(), topLevelStageContext: `[`StageWrapperContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-stage-wrapper-context/index.md)`<`[`TopLevelStageContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-top-level-stage-context/index.md)`>, postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)` = PostContext(), pipelineMethodRegistry: `[`PipelineMethodRegistry`](../../com.code42.jenkins.pipelinekt.dsl.method/-pipeline-method-registry/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [agentContext](agent-context.md) | `val agentContext: `[`SingletonDslContext`](../-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>` |
| [optionContext](option-context.md) | `val optionContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`>` |
| [parametersContext](parameters-context.md) | `val parametersContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md)`>` |
| [pipelineMethodRegistry](pipeline-method-registry.md) | `val pipelineMethodRegistry: `[`PipelineMethodRegistry`](../../com.code42.jenkins.pipelinekt.dsl.method/-pipeline-method-registry/index.md) |
| [postContext](post-context.md) | `val postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md) |
| [toolContext](tool-context.md) | `val toolContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [topLevelStageContext](top-level-stage-context.md) | `val topLevelStageContext: `[`StageWrapperContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-stage-wrapper-context/index.md)`<`[`TopLevelStageContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-top-level-stage-context/index.md)`>` |
| [triggersContext](triggers-context.md) | `val triggersContext: `[`DslContext`](../-dsl-context/index.md)`<`[`Trigger`](../../com.code42.jenkins.pipelinekt.core/-trigger.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [agent](agent.md) | `fun agent(agentBlock: `[`SingletonDslContext`](../-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [options](options.md) | `fun options(optionsBlock: `[`DslContext`](../-dsl-context/index.md)`<`[`Option`](../../com.code42.jenkins.pipelinekt.core/-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [parameters](parameters.md) | `fun parameters(parametersBlock: `[`DslContext`](../-dsl-context/index.md)`<`[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [post](post.md) | `fun post(postBlocck: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stages](stages.md) | `fun stages(stagesBlock: `[`StageWrapperContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-stage-wrapper-context/index.md)`<`[`TopLevelStageContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-top-level-stage-context/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tools](tools.md) | `fun tools(toolsBlock: `[`DslContext`](../-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [triggers](triggers.md) | `fun triggers(triggersBlock: `[`DslContext`](../-dsl-context/index.md)`<`[`Trigger`](../../com.code42.jenkins.pipelinekt.core/-trigger.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
