[pipelinekt](../../../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../../../index.md) / [Docker](../../index.md) / [ImageOps](../index.md) / [WithRun](./index.md)

# WithRun

`data class WithRun : `[`Docker`](../../index.md)`, `[`NestedStep`](../../../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Docker.kt#L51)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WithRun(args: Str = "".strSingle(), command: Str? = "".strDouble(), steps: `[`Step`](../../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`, containerVariable: Variable = "container".groovyVariable())` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `val args: Str` |
| [command](command.md) | `val command: Str?` |
| [containerVariable](container-variable.md) | `val containerVariable: Variable` |
| [steps](steps.md) | `val steps: `[`Step`](../../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
