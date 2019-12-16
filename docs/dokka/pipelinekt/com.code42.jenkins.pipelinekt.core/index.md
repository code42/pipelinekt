[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.core](./index.md)

## Package com.code42.jenkins.pipelinekt.core

### Types

| Name | Summary |
|---|---|
| [Agent](-agent.md) | `interface Agent : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Cause](-cause/index.md) | `sealed class Cause` |
| [Comparator](-comparator/index.md) | `sealed class Comparator` |
| [Option](-option.md) | `interface Option : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Parameter](-parameter/index.md) | `interface Parameter : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Pipeline](-pipeline/index.md) | `data class Pipeline : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Post](-post/index.md) | `data class Post : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [StageOption](-stage-option.md) | `interface StageOption : `[`Option`](-option.md) |
| [Tool](-tool.md) | `interface Tool : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Trigger](-trigger.md) | `interface Trigger : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [When](-when.md) | `interface When : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |

### Functions

| Name | Summary |
|---|---|
| [generatePipeline](generate-pipeline.md) | `fun generatePipeline(pipeline: `[`Pipeline`](-pipeline/index.md)`, outFile: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, indentStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "  "): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
