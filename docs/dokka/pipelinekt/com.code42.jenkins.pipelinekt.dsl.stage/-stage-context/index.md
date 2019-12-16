[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [StageContext](./index.md)

# StageContext

`interface StageContext` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/StageContext.kt#L13)

### Functions

| Name | Summary |
|---|---|
| [agent](agent.md) | `abstract fun agent(agentBlock: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [matrix](matrix.md) | `abstract fun matrix(matrixBlock: `[`MatrixContext`](../-matrix-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [options](options.md) | `abstract fun options(optionsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [parallel](parallel.md) | `abstract fun parallel(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](../-nested-stage-context/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [post](post.md) | `abstract fun post(postBlocck: `[`PostContext`](../../com.code42.jenkins.pipelinekt.dsl.post/-post-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stages](stages.md) | `abstract fun stages(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](../-nested-stage-context/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [steps](steps.md) | `abstract fun steps(stepsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tools](tools.md) | `abstract fun tools(toolsBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toStage](to-stage.md) | `abstract fun toStage(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md) |
| [when](when.md) | `abstract fun when(whenBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [NestedStageContext](../-nested-stage-context/index.md) | `open class NestedStageContext : `[`StageContext`](./index.md) |
| [TopLevelStageContext](../-top-level-stage-context/index.md) | `open class TopLevelStageContext : `[`StageContext`](./index.md) |
