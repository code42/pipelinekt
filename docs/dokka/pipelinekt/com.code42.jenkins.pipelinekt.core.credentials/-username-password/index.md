[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.credentials](../index.md) / [UsernamePassword](./index.md)

# UsernamePassword

`data class UsernamePassword : `[`JenkinsCredentials`](../-jenkins-credentials/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/credentials/UsernamePassword.kt#L5)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UsernamePassword(credentialsId: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`, usernameVariable: Str, passwordVariable: Str)` |

### Properties

| Name | Summary |
|---|---|
| [credentialsId](credentials-id.md) | `val credentialsId: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md) |
| [passwordVariable](password-variable.md) | `val passwordVariable: Str` |
| [usernameVariable](username-variable.md) | `val usernameVariable: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
