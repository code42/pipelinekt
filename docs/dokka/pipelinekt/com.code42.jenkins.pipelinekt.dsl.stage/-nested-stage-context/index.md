[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [NestedStageContext](./index.md)

# NestedStageContext

`open class NestedStageContext : `[`StageContext`](../-stage-context/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/NestedStageContext.kt#L15)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NestedStageContext(agentContext: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`> = SingletonDslContext(), stepContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`> = DslContext(), nestedStageContext: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](./index.md)`>, postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)` = PostContext(), whenContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`> = DslContext(), toolContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = DslContext(), optionContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`> = DslContext())` |

### Properties

| Name | Summary |
|---|---|
| [agentContext](agent-context.md) | `val agentContext: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>` |
| [nestedStageContext](nested-stage-context.md) | `val nestedStageContext: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](./index.md)`>` |
| [optionContext](option-context.md) | `val optionContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>` |
| [postContext](post-context.md) | `val postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md) |
| [stepContext](step-context.md) | `val stepContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |
| [toolContext](tool-context.md) | `val toolContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [whenContext](when-context.md) | `val whenContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [agent](agent.md) | `open fun agent(agentBlock: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [matrix](matrix.md) | This method is here to prevent calling parallel in nested stages.  This method should never be invoked.`open fun matrix(matrixBlock: `[`MatrixContext`](../-matrix-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [options](options.md) | `open fun options(optionsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [parallel](parallel.md) | This method is here to prevent calling parallel in nested stages.  This method should never be invoked.`open fun ~~parallel~~(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](./index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [post](post.md) | `open fun post(postBlocck: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stages](stages.md) | `open fun stages(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](./index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [steps](steps.md) | `open fun steps(stepBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tools](tools.md) | `open fun tools(toolsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toStage](to-stage.md) | `open fun toStage(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md) |
| [when](when.md) | `open fun when(whenBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
