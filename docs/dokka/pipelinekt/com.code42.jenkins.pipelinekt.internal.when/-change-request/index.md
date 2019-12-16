[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.when](../index.md) / [ChangeRequest](./index.md)

# ChangeRequest

`sealed class ChangeRequest : `[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/when/ChangeRequest.kt#L8)

### Types

| Name | Summary |
|---|---|
| [Author](-author/index.md) | `data class Author : `[`ChangeRequest`](./index.md) |
| [AuthorDisplayName](-author-display-name/index.md) | `data class AuthorDisplayName : `[`ChangeRequest`](./index.md) |
| [AuthorEmail](-author-email/index.md) | `data class AuthorEmail : `[`ChangeRequest`](./index.md) |
| [Branch](-branch/index.md) | `data class Branch : `[`ChangeRequest`](./index.md) |
| [Fork](-fork/index.md) | `data class Fork : `[`ChangeRequest`](./index.md) |
| [Id](-id/index.md) | `data class Id : `[`ChangeRequest`](./index.md) |
| [Target](-target/index.md) | `data class Target : `[`ChangeRequest`](./index.md) |
| [Title](-title/index.md) | `data class Title : `[`ChangeRequest`](./index.md) |
| [Url](-url/index.md) | `data class Url : `[`ChangeRequest`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [comparator](comparator.md) | `abstract val comparator: `[`Comparator`](../../com.code42.jenkins.pipelinekt.core/-comparator/index.md) |
| [name](name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [value](value.md) | `abstract val value: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `open fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
