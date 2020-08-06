[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Sh](./index.md)

# Sh

`data class Sh : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md)

Execute a shell command

### Parameters

`script` - The shell script or command to execute.

`returnStdout` - If checked, standard output from the task is returned as the step value as a String, rather than being printed to the build log. (Standard error, if any, will still be printed to the log.) You will often want to call .trim() on the result to strip off a trailing newline.

`label` - Label to be displayed in the pipeline step view and blue ocean details for the step instead of the step type. So the view is more meaningful and domain specific instead of technical.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Execute a shell command`Sh(script: Str, returnStdout: Bool = false.boolVar(), label: Str? = null)` |

### Properties

| Name | Summary |
|---|---|
| [label](label.md) | Label to be displayed in the pipeline step view and blue ocean details for the step instead of the step type. So the view is more meaningful and domain specific instead of technical.`val label: Str?` |
| [returnStdout](return-stdout.md) | If checked, standard output from the task is returned as the step value as a String, rather than being printed to the build log. (Standard error, if any, will still be printed to the log.) You will often want to call .trim() on the result to strip off a trailing newline.`val returnStdout: Bool` |
| [script](script.md) | The shell script or command to execute.`val script: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
