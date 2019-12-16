[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [MatrixContext](./index.md)

# MatrixContext

`data class MatrixContext` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/MatrixContext.kt#L17)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MatrixContext(nestedStageContext: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](../-nested-stage-context/index.md)`>, axesContext: `[`MatrixAxisContext`](../-matrix-axis-context/index.md)` = MatrixAxisContext(), excludesContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`MatrixExclude`](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-exclude/index.md)`> = DslContext(), agentContext: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`> = SingletonDslContext(), whenContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`> = DslContext(), toolContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = DslContext(), optionContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`> = DslContext(), postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)` = PostContext())` |

### Properties

| Name | Summary |
|---|---|
| [agentContext](agent-context.md) | `val agentContext: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>` |
| [axesContext](axes-context.md) | `val axesContext: `[`MatrixAxisContext`](../-matrix-axis-context/index.md) |
| [excludesContext](excludes-context.md) | `val excludesContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`MatrixExclude`](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-exclude/index.md)`>` |
| [nestedStageContext](nested-stage-context.md) | `val nestedStageContext: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](../-nested-stage-context/index.md)`>` |
| [optionContext](option-context.md) | `val optionContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>` |
| [postContext](post-context.md) | `val postContext: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md) |
| [toolContext](tool-context.md) | `val toolContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [whenContext](when-context.md) | `val whenContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [agent](agent.md) | `fun agent(agentBlock: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [axes](axes.md) | `fun axes(axesBlock: `[`MatrixAxisContext`](../-matrix-axis-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [excludes](excludes.md) | `fun excludes(excludesBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`MatrixExclude`](../../com.code42.jenkins.pipelinekt.core.stage/-matrix-exclude/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [options](options.md) | `fun options(optionsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [post](post.md) | `fun post(postBlock: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stages](stages.md) | `fun stages(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](../-nested-stage-context/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tools](tools.md) | `fun tools(toolsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [when](when.md) | `fun when(whenBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
