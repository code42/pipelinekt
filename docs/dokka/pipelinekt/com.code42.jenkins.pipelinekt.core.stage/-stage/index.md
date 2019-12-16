[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.stage](../index.md) / [Stage](./index.md)

# Stage

`sealed class Stage : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/stage/Stage.kt#L17)

A declarative Jenkinsfile Stage

### Types

| Name | Summary |
|---|---|
| [Matrix](-matrix/index.md) | `data class Matrix : `[`Stage`](./index.md) |
| [Parallel](-parallel/index.md) | Execute stages in parallel`data class Parallel : `[`Stage`](./index.md) |
| [Sequence](-sequence/index.md) | `data class Sequence : `[`Stage`](./index.md) |
| [Steps](-steps/index.md) | A declarative stage`data class Steps : `[`Stage`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [agent](agent.md) | `abstract val agent: `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`?` |
| [options](options.md) | `abstract val options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>` |
| [post](post.md) | `abstract val post: `[`Post`](../../com.code42.jenkins.pipelinekt.core/-post/index.md)`?` |
| [tools](tools.md) | `abstract val tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [whenBlock](when-block.md) | `abstract val whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>?` |
