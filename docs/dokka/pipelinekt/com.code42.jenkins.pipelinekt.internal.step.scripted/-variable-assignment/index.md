[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [VariableAssignment](./index.md)

# VariableAssignment

`data class VariableAssignment : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/VariableAssignment.kt#L14)

Declare a variable and assign it to the output of some steps

**Parameters**

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Declare a variable and assign it to the output of some steps`VariableAssignment(variable: Variable, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [steps](steps.md) | `val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [variable](variable.md) | `val variable: Variable` |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
