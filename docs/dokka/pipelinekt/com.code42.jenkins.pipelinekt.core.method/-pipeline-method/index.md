[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.method](../index.md) / [PipelineMethod](./index.md)

# PipelineMethod

`data class PipelineMethod : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/method/PipelineMethod.kt#L7)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PipelineMethod(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [steps](steps.md) | `val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [invocation](invocation.md) | Static method, recommended for internal use only. Users: Please favor PipelineMethodDsl.`fun invocation(method: `[`PipelineMethod`](./index.md)`): `[`PipelineMethodInvocation`](../-pipeline-method-invocation/index.md) |
