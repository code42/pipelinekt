[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core](../index.md) / [Parameter](./index.md)

# Parameter

`interface Parameter : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/Parameter.kt#L6)

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `abstract val name: Str` |

### Functions

| Name | Summary |
|---|---|
| [toXml](to-xml.md) | `abstract fun toXml(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanParam](../../com.code42.jenkins.pipelinekt.internal.parameters/-boolean-param/index.md) | Boolean Pipeline Param`data class BooleanParam : `[`Parameter`](./index.md) |
| [Choice](../../com.code42.jenkins.pipelinekt.internal.parameters/-choice/index.md) | `data class Choice : `[`Parameter`](./index.md) |
| [File](../../com.code42.jenkins.pipelinekt.internal.parameters/-file/index.md) | `data class File : `[`Parameter`](./index.md) |
| [Password](../../com.code42.jenkins.pipelinekt.internal.parameters/-password/index.md) | `data class Password : `[`Parameter`](./index.md) |
| [StringParam](../../com.code42.jenkins.pipelinekt.internal.parameters/-string-param/index.md) | String Param`data class StringParam : `[`Parameter`](./index.md) |
| [Text](../../com.code42.jenkins.pipelinekt.internal.parameters/-text/index.md) | Multiline String`data class Text : `[`Parameter`](./index.md) |
