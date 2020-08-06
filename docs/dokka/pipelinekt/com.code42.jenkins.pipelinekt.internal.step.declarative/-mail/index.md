[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Mail](./index.md)

# Mail

`data class Mail : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md)

Simple step for sending email.

### Parameters

`to` - To email address list. Comma separated list of email addresses.

`subject` - Email subject line.

`body` - Email body.

`cc` - CC email address list. Comma separated list of email addresses.

`bcc` - BCC email address list. Comma separated list of email addresses.

`from` - From email address. Defaults to the admin address globally configured for the Jenkins instance.

`replyTo` - Reply-To email address. Defaults to the admin address globally configured for the Jenkins instance.

`mimeType` - Email body MIME type. Defaults to text/plain.

`charset` - Email body character encoding. Defaults to UTF-8.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Simple step for sending email.`Mail(to: Str = "".strSingle(), subject: Str = "".strSingle(), body: Str = "".strSingle(), cc: Str = "".strSingle(), bcc: Str = "".strSingle(), from: Str = "".strSingle(), replyTo: Str = "".strSingle(), mimeType: Str = "".strSingle(), charset: Str = "".strSingle())` |

### Properties

| Name | Summary |
|---|---|
| [bcc](bcc.md) | BCC email address list. Comma separated list of email addresses.`val bcc: Str` |
| [body](body.md) | Email body.`val body: Str` |
| [cc](cc.md) | CC email address list. Comma separated list of email addresses.`val cc: Str` |
| [charset](charset.md) | Email body character encoding. Defaults to UTF-8.`val charset: Str` |
| [from](from.md) | From email address. Defaults to the admin address globally configured for the Jenkins instance.`val from: Str` |
| [mimeType](mime-type.md) | Email body MIME type. Defaults to text/plain.`val mimeType: Str` |
| [replyTo](reply-to.md) | Reply-To email address. Defaults to the admin address globally configured for the Jenkins instance.`val replyTo: Str` |
| [subject](subject.md) | Email subject line.`val subject: Str` |
| [to](to.md) | To email address list. Comma separated list of email addresses.`val to: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
