[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.conditional](../../index.md) / [BooleanStatement](../index.md) / [BinaryOperator](./index.md)

# BinaryOperator

`sealed class BinaryOperator : `[`BooleanStatement`](../index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/conditional/BooleanStatement.kt#L28)

### Types

| Name | Summary |
|---|---|
| [And](-and/index.md) | `data class And : BinaryOperator` |
| [Equals](-equals/index.md) | `data class Equals : BinaryOperator` |
| [Or](-or/index.md) | `data class Or : BinaryOperator` |

### Properties

| Name | Summary |
|---|---|
| [left](left.md) | `abstract val left: `[`BooleanStatement`](../index.md) |
| [operator](operator.md) | `abstract val operator: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [right](right.md) | `abstract val right: `[`BooleanStatement`](../index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `open fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
