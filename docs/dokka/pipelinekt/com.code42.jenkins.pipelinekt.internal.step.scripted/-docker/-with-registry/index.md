[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../../index.md) / [Docker](../index.md) / [WithRegistry](./index.md)

# WithRegistry

`data class WithRegistry : `[`Docker`](../index.md)`, `[`NestedStep`](../../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Docker.kt#L114)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WithRegistry(url: Str, credentialsId: Str? = null, steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [credentialsId](credentials-id.md) | `val credentialsId: Str?` |
| [steps](steps.md) | `val steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [url](url.md) | `val url: Str` |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
