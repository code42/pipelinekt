[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [WithCredentials](./index.md)

# WithCredentials

`data class WithCredentials : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/WithCredentials.kt#L15)

Inject credentials to some steps

### Parameters

`credentials` - the credentials to inject

`steps` - the steps to inject

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Inject credentials to some steps`WithCredentials(credentials: `[`JenkinsCredentials`](../../com.code42.jenkins.pipelinekt.core.credentials/-jenkins-credentials/index.md)`, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [credentials](credentials.md) | the credentials to inject`val credentials: `[`JenkinsCredentials`](../../com.code42.jenkins.pipelinekt.core.credentials/-jenkins-credentials/index.md) |
| [steps](steps.md) | the steps to inject`val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
