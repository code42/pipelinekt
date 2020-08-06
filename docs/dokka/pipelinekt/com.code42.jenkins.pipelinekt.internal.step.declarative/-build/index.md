[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Build](./index.md)

# Build

`data class Build : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Build(job: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`, parameters: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BuildParameterValue`](../../com.code42.jenkins.pipelinekt.core.build-parameter/-build-parameter-value/index.md)`>, wait: Bool)` |

### Properties

| Name | Summary |
|---|---|
| [job](job.md) | `val job: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md) |
| [parameters](parameters.md) | `val parameters: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BuildParameterValue`](../../com.code42.jenkins.pipelinekt.core.build-parameter/-build-parameter-value/index.md)`>` |
| [wait](wait.md) | `val wait: Bool` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
