[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [If](./index.md)

# If

`data class If : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/If.kt#L10)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `If(statement: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`, ifTrue: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`, otherwise: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`? = null)` |

### Properties

| Name | Summary |
|---|---|
| [ifTrue](if-true.md) | `val ifTrue: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [otherwise](otherwise.md) | `val otherwise: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`?` |
| [statement](statement.md) | `val statement: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [steps](steps.md) | `val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
