[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.conditional](../index.md) / [BooleanStatement](./index.md)

# BooleanStatement

`sealed class BooleanStatement` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/conditional/BooleanStatement.kt#L5)

### Types

| Name | Summary |
|---|---|
| [BinaryOperator](-binary-operator/index.md) | `sealed class BinaryOperator : `[`BooleanStatement`](./index.md) |
| [Literal](-literal/index.md) | `data class Literal : `[`BooleanStatement`](./index.md) |
| [Not](-not/index.md) | `data class Not : `[`BooleanStatement`](./index.md) |
| [StringOperator](-string-operator/index.md) | `sealed class StringOperator : `[`BooleanStatement`](./index.md) |
| [Variable](-variable/index.md) | `data class Variable : `[`BooleanStatement`](./index.md) |

### Functions

| Name | Summary |
|---|---|
| [interpolated](interpolated.md) | `fun interpolated(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [&amp;&amp;](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/&&.md) | `infix fun `[`BooleanStatement`](./index.md)`.&&(other: `[`BooleanStatement`](./index.md)`): `[`BooleanStatement`](./index.md)<br>`infix fun `[`BooleanStatement`](./index.md)`.&&(other: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): `[`BooleanStatement`](./index.md) |
| [==](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/==.md) | `infix fun `[`BooleanStatement`](./index.md)`.==(other: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`BooleanStatement`](./index.md)<br>`infix fun `[`BooleanStatement`](./index.md)`.==(other: `[`BooleanStatement`](./index.md)`): `[`BooleanStatement`](./index.md) |
| [||](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/||.md) | `infix fun `[`BooleanStatement`](./index.md)`.||(other: `[`BooleanStatement`](./index.md)`): `[`BooleanStatement`](./index.md)<br>`infix fun `[`BooleanStatement`](./index.md)`.||(other: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): `[`BooleanStatement`](./index.md) |
