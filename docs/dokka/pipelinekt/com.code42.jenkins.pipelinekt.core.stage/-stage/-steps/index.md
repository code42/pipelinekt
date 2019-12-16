[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.stage](../../index.md) / [Stage](../index.md) / [Steps](./index.md)

# Steps

`data class Steps : `[`Stage`](../index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/stage/Stage.kt#L100)

A declarative stage

### Parameters

`name` - the stage name

`agent` - the optional agent definition

`steps` - the steps to execute

`post` - steps to execute after steps has completed

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | A declarative stage`Steps(name: Str, steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`, agent: `[`Agent`](../../../com.code42.jenkins.pipelinekt.core/-agent.md)`? = null, whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../../com.code42.jenkins.pipelinekt.core/-when.md)`> = emptyList(), tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = emptyList(), options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`> = emptyList(), post: `[`Post`](../../../com.code42.jenkins.pipelinekt.core/-post/index.md)` = Post())` |

### Properties

| Name | Summary |
|---|---|
| [agent](agent.md) | the optional agent definition`val agent: `[`Agent`](../../../com.code42.jenkins.pipelinekt.core/-agent.md)`?` |
| [name](name.md) | the stage name`val name: Str` |
| [options](options.md) | `val options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>` |
| [post](post.md) | steps to execute after steps has completed`val post: `[`Post`](../../../com.code42.jenkins.pipelinekt.core/-post/index.md) |
| [steps](steps.md) | the steps to execute`val steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [tools](tools.md) | `val tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [whenBlock](when-block.md) | `val whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../../com.code42.jenkins.pipelinekt.core/-when.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
