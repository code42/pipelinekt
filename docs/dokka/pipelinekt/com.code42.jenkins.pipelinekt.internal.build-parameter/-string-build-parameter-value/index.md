[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.buildParameter](../index.md) / [StringBuildParameterValue](./index.md)

# StringBuildParameterValue

`data class StringBuildParameterValue : `[`BuildParameterValue`](../../com.code42.jenkins.pipelinekt.core.build-parameter/-build-parameter-value/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/buildParameter/StringBuildParameterValue.kt#L9)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StringBuildParameterValue(name: Str, value: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: Str` |
| [value](value.md) | `val value: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toParameterDefintion](to-parameter-defintion.md) | `fun toParameterDefintion(): `[`Parameter`](../../com.code42.jenkins.pipelinekt.core/-parameter/index.md) |
