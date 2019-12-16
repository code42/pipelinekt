[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Bat](./index.md)

# Bat

`data class Bat : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/Bat.kt#L15)

Execute a shell command

### Parameters

`script` - the shell script to execute

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Execute a shell command`Bat(script: Str, returnStdout: Bool = false.boolVar(), label: Str? = null)` |

### Properties

| Name | Summary |
|---|---|
| [label](label.md) | `val label: Str?` |
| [returnStdout](return-stdout.md) | `val returnStdout: Bool` |
| [script](script.md) | the shell script to execute`val script: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
