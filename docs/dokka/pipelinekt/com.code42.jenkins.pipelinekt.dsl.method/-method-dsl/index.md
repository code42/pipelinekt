[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.method](../index.md) / [MethodDsl](./index.md)

# MethodDsl

`interface MethodDsl` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/method/MethodDsl.kt#L9)

### Properties

| Name | Summary |
|---|---|
| [pipelineMethodRegistry](pipeline-method-registry.md) | `abstract val pipelineMethodRegistry: `[`PipelineMethodRegistry`](../-pipeline-method-registry/index.md) |

### Functions

| Name | Summary |
|---|---|
| [invoke](invoke.md) | `open fun `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.invoke(method: `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [method](method.md) | `open fun method(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [withConfigurationContext](../../com.code42.jenkins.pipelinekt.dsl/with-configuration-context.md) | `fun <T, Dsl : `[`MethodDsl`](./index.md)`> Dsl.withConfigurationContext(applyConfiguration: Dsl.() -> Dsl, stage: Dsl.() -> T): T` |

### Inheritors

| Name | Summary |
|---|---|
| [PipelineDsl](../../com.code42.jenkins.pipelinekt.dsl/-pipeline-dsl/index.md) | `data class PipelineDsl : `[`MethodDsl`](./index.md) |
| [StageWrapperContext](../../com.code42.jenkins.pipelinekt.dsl.stage/-stage-wrapper-context/index.md) | `data class StageWrapperContext<I : `[`StageContext`](../../com.code42.jenkins.pipelinekt.dsl.stage/-stage-context/index.md)`> : `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Stage`](../../com.code42.jenkins.pipelinekt.core.stage/-stage/index.md)`>, `[`MethodDsl`](./index.md) |
