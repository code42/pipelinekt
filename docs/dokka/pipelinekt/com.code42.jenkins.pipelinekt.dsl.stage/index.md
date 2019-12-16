[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](./index.md)

## Package com.code42.jenkins.pipelinekt.dsl.stage

### Types

| Name | Summary |
|---|---|
| [MatrixAxisContext](-matrix-axis-context/index.md) | `data class MatrixAxisContext : `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`MatrixAxis`](../com.code42.jenkins.pipelinekt.core.stage/-matrix-axis/index.md)`>` |
| [MatrixContext](-matrix-context/index.md) | `data class MatrixContext` |
| [MatrixExcludeAxisContext](-matrix-exclude-axis-context/index.md) | `data class MatrixExcludeAxisContext : `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`ExcludeAxis`](../com.code42.jenkins.pipelinekt.core.stage/-exclude-axis/index.md)`>` |
| [NestedStageContext](-nested-stage-context/index.md) | `open class NestedStageContext : `[`StageContext`](-stage-context/index.md) |
| [StageContext](-stage-context/index.md) | `interface StageContext` |
| [StageWrapperContext](-stage-wrapper-context/index.md) | `data class StageWrapperContext<I : `[`StageContext`](-stage-context/index.md)`> : `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Stage`](../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`>, `[`MethodDsl`](../com.code42.jenkins.pipelinekt.dsl.method/-method-dsl/index.md) |
| [TopLevelStageContext](-top-level-stage-context/index.md) | `open class TopLevelStageContext : `[`StageContext`](-stage-context/index.md) |

### Functions

| Name | Summary |
|---|---|
| [exclude](exclude.md) | `fun `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`MatrixExclude`](../com.code42.jenkins.pipelinekt.core.stage/-matrix-exclude/index.md)`>.exclude(excludeBlock: `[`MatrixExcludeAxisContext`](-matrix-exclude-axis-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
