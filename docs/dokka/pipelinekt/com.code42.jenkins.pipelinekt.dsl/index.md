[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.dsl](./index.md)

## Package com.code42.jenkins.pipelinekt.dsl

### Types

| Name | Summary |
|---|---|
| [DslContext](-dsl-context/index.md) | `open class DslContext<T>` |
| [PipelineContext](-pipeline-context/index.md) | `data class PipelineContext` |
| [PipelineDsl](-pipeline-dsl/index.md) | `data class PipelineDsl : `[`MethodDsl`](../com.code42.jenkins.pipelinekt.dsl.method/-method-dsl/index.md) |
| [SingletonDslContext](-singleton-dsl-context/index.md) | `open class SingletonDslContext<T>` |

### Functions

| Name | Summary |
|---|---|
| [into](into.md) | `fun <T, Dsl : `[`DslContext`](-dsl-context/index.md)`<T>> Dsl.into(block: Dsl.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>` |
| [withConfigurationContext](with-configuration-context.md) | `fun <T, Dsl : `[`MethodDsl`](../com.code42.jenkins.pipelinekt.dsl.method/-method-dsl/index.md)`> Dsl.withConfigurationContext(applyConfiguration: Dsl.() -> Dsl, stage: Dsl.() -> T): T` |
