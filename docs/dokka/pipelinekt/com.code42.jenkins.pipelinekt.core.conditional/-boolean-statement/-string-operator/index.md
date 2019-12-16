[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.conditional](../../index.md) / [BooleanStatement](../index.md) / [StringOperator](./index.md)

# StringOperator

`sealed class StringOperator : `[`BooleanStatement`](../index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/conditional/BooleanStatement.kt#L46)

### Types

| Name | Summary |
|---|---|
| [Contains](-contains/index.md) | `data class Contains : StringOperator` |
| [EndsWith](-ends-with/index.md) | `data class EndsWith : StringOperator` |
| [StartsWith](-starts-with/index.md) | `data class StartsWith : StringOperator` |

### Properties

| Name | Summary |
|---|---|
| [left](left.md) | `abstract val left: `[`Var`](../../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md) |
| [operator](operator.md) | `abstract val operator: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [right](right.md) | `abstract val right: `[`Var`](../../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `open fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
