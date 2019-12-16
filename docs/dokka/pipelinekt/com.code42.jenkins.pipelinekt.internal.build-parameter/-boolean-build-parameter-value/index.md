[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.buildParameter](../index.md) / [BooleanBuildParameterValue](./index.md)

# BooleanBuildParameterValue

`data class BooleanBuildParameterValue : `[`BuildParameterValue`](../../com.code42.jenkins.pipelinekt.core.build-parameter/-build-parameter-value/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/buildParameter/BooleanBuildParameterValue.kt#L9)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BooleanBuildParameterValue(name: Str, value: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`)` |

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
