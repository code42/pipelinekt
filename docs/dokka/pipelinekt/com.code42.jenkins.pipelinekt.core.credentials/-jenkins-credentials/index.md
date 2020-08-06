[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.credentials](../index.md) / [JenkinsCredentials](./index.md)

# JenkinsCredentials

`interface JenkinsCredentials`

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [File](../-file/index.md) | `data class File : `[`JenkinsCredentials`](./index.md) |
| [SshUserPrivateKey](../-ssh-user-private-key/index.md) | `data class SshUserPrivateKey : `[`JenkinsCredentials`](./index.md) |
| [Text](../-text/index.md) | `data class Text : `[`JenkinsCredentials`](./index.md) |
| [UsernamePassword](../-username-password/index.md) | `data class UsernamePassword : `[`JenkinsCredentials`](./index.md) |
