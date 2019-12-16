[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Echo](./index.md)

# Echo

`data class Echo : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/Echo.kt#L13)

Echo a string to the terminal

### Parameters

`string` - string to echo

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Echo a string to the terminal`Echo(string: Str)` |

### Properties

| Name | Summary |
|---|---|
| [string](string.md) | string to echo`val string: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
