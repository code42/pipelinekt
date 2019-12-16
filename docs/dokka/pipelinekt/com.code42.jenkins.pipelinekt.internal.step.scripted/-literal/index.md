[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [Literal](./index.md)

# Literal

`data class Literal : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Literal.kt#L12)

Define arbitrary scripted Jenkinsfile code blocks

### Parameters

`codeBlock` - a literal code block to inject into the generated Jenkinsfile

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Define arbitrary scripted Jenkinsfile code blocks`Literal(codeBlock: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [codeBlock](code-block.md) | a literal code block to inject into the generated Jenkinsfile`val codeBlock: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
