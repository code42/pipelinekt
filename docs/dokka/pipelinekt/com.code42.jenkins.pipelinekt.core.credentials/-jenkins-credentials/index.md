[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.credentials](../index.md) / [JenkinsCredentials](./index.md)

# JenkinsCredentials

`interface JenkinsCredentials` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/credentials/JenkinsCredentials.kt#L3)

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [SshUserPrivateKey](../-ssh-user-private-key/index.md) | `data class SshUserPrivateKey : `[`JenkinsCredentials`](./index.md) |
| [UsernamePassword](../-username-password/index.md) | `data class UsernamePassword : `[`JenkinsCredentials`](./index.md) |
