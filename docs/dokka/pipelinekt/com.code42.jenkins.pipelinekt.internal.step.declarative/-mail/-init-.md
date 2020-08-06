[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Mail](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Mail(to: Str = "".strSingle(), subject: Str = "".strSingle(), body: Str = "".strSingle(), cc: Str = "".strSingle(), bcc: Str = "".strSingle(), from: Str = "".strSingle(), replyTo: Str = "".strSingle(), mimeType: Str = "".strSingle(), charset: Str = "".strSingle())`

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