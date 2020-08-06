[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.buildParameter](../index.md) / [BuildParameterValue](./index.md)

# BuildParameterValue

`interface BuildParameterValue`

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toParameterDefintion](to-parameter-defintion.md) | `abstract fun toParameterDefintion(): `[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [BooleanBuildParameterValue](../../com.code42.jenkins.pipelinekt.internal.build-parameter/-boolean-build-parameter-value/index.md) | `data class BooleanBuildParameterValue : `[`BuildParameterValue`](./index.md) |
| [StringBuildParameterValue](../../com.code42.jenkins.pipelinekt.internal.build-parameter/-string-build-parameter-value/index.md) | `data class StringBuildParameterValue : `[`BuildParameterValue`](./index.md) |
