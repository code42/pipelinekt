[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.when](../index.md) / [Before](./index.md)

# Before

`sealed class Before : `[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/when/Before.kt#L6)

### Types

| Name | Summary |
|---|---|
| [Agent](-agent/index.md) | `data class Agent : `[`Before`](./index.md) |
| [Input](-input/index.md) | `data class Input : `[`Before`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [enabled](enabled.md) | `abstract val enabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [name](name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `open fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
