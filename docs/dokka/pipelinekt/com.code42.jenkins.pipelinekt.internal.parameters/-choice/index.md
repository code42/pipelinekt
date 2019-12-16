[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.parameters](../index.md) / [Choice](./index.md)

# Choice

`data class Choice : `[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/parameters/Choice.kt#L7)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Choice(name: Str, choices: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Str>, description: Str)` |

### Properties

| Name | Summary |
|---|---|
| [choices](choices.md) | `val choices: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Str>` |
| [description](description.md) | `val description: Str` |
| [name](name.md) | `val name: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toXml](to-xml.md) | `fun toXml(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
