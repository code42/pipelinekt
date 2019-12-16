[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.parameters](../index.md) / [BooleanParam](./index.md)

# BooleanParam

`data class BooleanParam : `[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/parameters/BooleanParam.kt#L10)

Boolean Pipeline Param

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Boolean Pipeline Param`BooleanParam(defaultValue: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, description: Str, name: Str)` |

### Properties

| Name | Summary |
|---|---|
| [defaultValue](default-value.md) | `val defaultValue: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [description](description.md) | `val description: Str` |
| [name](name.md) | `val name: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toXml](to-xml.md) | `fun toXml(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
