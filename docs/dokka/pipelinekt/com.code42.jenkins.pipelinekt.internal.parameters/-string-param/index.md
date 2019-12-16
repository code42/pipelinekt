[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.parameters](../index.md) / [StringParam](./index.md)

# StringParam

`data class StringParam : `[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/parameters/StringParam.kt#L10)

String Param

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | String Param`StringParam(defaultValue: Str, description: Str, name: Str)` |

### Properties

| Name | Summary |
|---|---|
| [defaultValue](default-value.md) | `val defaultValue: Str` |
| [description](description.md) | `val description: Str` |
| [name](name.md) | `val name: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toXml](to-xml.md) | `fun toXml(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
