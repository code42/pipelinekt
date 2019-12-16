[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.method](../index.md) / [PipelineMethodRegistry](./index.md)

# PipelineMethodRegistry

`class PipelineMethodRegistry` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/method/PipelineMethodRegistry.kt#L4)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PipelineMethodRegistry()` |

### Functions

| Name | Summary |
|---|---|
| [methods](methods.md) | `fun methods(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`>` |
| [registerMethod](register-method.md) | `fun registerMethod(method: `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [reset](reset.md) | `fun reset(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [validate](validate.md) | `fun validate(newPipelineMethod: `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`, existingMethods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun validate(newPipelineMethod: `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`, existingMethods: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`PipelineMethod`](../../com.code42.jenkins.pipelinekt.core.method/-pipeline-method/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
