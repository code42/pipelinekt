[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.vars](../index.md) / [Var](./index.md)

# Var

`sealed class Var` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/vars/Var.kt#L12)

Represents a var that is written to groovy

### Types

| Name | Summary |
|---|---|
| [ClosureInvocation](-closure-invocation/index.md) | `data class ClosureInvocation : `[`Var`](./index.md) |
| [Environment](-environment/index.md) | Access an environment variable from groovy`data class Environment : `[`Var`](./index.md) |
| [External](-external/index.md) | `abstract class External : `[`Var`](./index.md) |
| [Field](-field/index.md) | `data class Field : `[`Var`](./index.md) |
| [Literal](-literal/index.md) | Access literal vars in groovy`sealed class Literal : `[`Var`](./index.md) |
| [Null](-null/index.md) | `object Null : `[`Var`](./index.md) |
| [Variable](-variable/index.md) | `data class Variable : `[`Var`](./index.md) |

### Functions

| Name | Summary |
|---|---|
| [interpolated](interpolated.md) | `fun interpolated(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [&amp;&amp;](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/&&.md) | `infix fun `[`Var`](./index.md)`.&&(other: `[`Var`](./index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](./index.md)`.&&(other: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [==](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/==.md) | `infix fun `[`Var`](./index.md)`.==(other: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](./index.md)`.==(other: `[`Var`](./index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [containsSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/contains-substring.md) | `fun `[`Var`](./index.md)`.containsSubstring(subString: `[`Var`](./index.md)`): Contains`<br>`fun `[`Var`](./index.md)`.containsSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Contains` |
| [endsWithSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/ends-with-substring.md) | `fun `[`Var`](./index.md)`.endsWithSubstring(subString: `[`Var`](./index.md)`): EndsWith`<br>`fun `[`Var`](./index.md)`.endsWithSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): EndsWith` |
| [startsWithSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/starts-with-substring.md) | `fun `[`Var`](./index.md)`.startsWithSubstring(subString: `[`Var`](./index.md)`): StartsWith`<br>`fun `[`Var`](./index.md)`.startsWithSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): StartsWith` |
| [statement](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/statement.md) | `fun `[`Var`](./index.md)`.statement(): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [||](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/||.md) | `infix fun `[`Var`](./index.md)`.||(other: `[`Var`](./index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](./index.md)`.||(other: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
