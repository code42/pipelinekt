[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.when](../index.md) / [Expression](./index.md)

# Expression

`data class Expression : `[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/when/Expression.kt#L7)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Expression(statement: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [statement](statement.md) | `val statement: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
