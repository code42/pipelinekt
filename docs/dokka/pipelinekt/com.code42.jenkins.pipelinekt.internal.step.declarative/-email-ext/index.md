[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [EmailExt](./index.md)

# EmailExt

`data class EmailExt : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/EmailExt.kt#L15)

Inject email into steps

### Parameters

`buildemail` - the build email to inject

`steps` - the steps to inject

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Inject email into steps`EmailExt(subject: Str, body: Str, emailRecipients: Str? = null, recipientProviders: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RecipientProvider`](../../com.code42.jenkins.pipelinekt.core.notifications/-recipient-provider/index.md)`>? = null)` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `val body: Str` |
| [emailRecipients](email-recipients.md) | `val emailRecipients: Str?` |
| [recipientProviders](recipient-providers.md) | `val recipientProviders: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`RecipientProvider`](../../com.code42.jenkins.pipelinekt.core.notifications/-recipient-provider/index.md)`>?` |
| [subject](subject.md) | `val subject: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
