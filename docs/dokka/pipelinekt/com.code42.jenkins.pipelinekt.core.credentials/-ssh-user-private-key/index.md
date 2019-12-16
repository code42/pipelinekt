[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.credentials](../index.md) / [SshUserPrivateKey](./index.md)

# SshUserPrivateKey

`data class SshUserPrivateKey : `[`JenkinsCredentials`](../-jenkins-credentials/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/credentials/SshUserPrivateKey.kt#L5)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SshUserPrivateKey(keyFileVariable: Environment, credentialsId: Str, passphraseVariable: Environment? = null, usernameVariable: Environment? = null)` |

### Properties

| Name | Summary |
|---|---|
| [credentialsId](credentials-id.md) | `val credentialsId: Str` |
| [keyFileVariable](key-file-variable.md) | `val keyFileVariable: Environment` |
| [passphraseVariable](passphrase-variable.md) | `val passphraseVariable: Environment?` |
| [usernameVariable](username-variable.md) | `val usernameVariable: Environment?` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
