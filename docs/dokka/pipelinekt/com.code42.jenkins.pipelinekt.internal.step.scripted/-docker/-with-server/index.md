[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../../index.md) / [Docker](../index.md) / [WithServer](./index.md)

# WithServer

`data class WithServer : `[`Docker`](../index.md)`, `[`NestedStep`](../../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WithServer(uri: Str, credentialsId: Str? = null, steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [credentialsId](credentials-id.md) | `val credentialsId: Str?` |
| [steps](steps.md) | `val steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [uri](uri.md) | `val uri: Str` |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
