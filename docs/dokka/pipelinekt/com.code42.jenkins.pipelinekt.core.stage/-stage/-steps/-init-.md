[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.stage](../../index.md) / [Stage](../index.md) / [Steps](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Steps(name: Str, steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`, agent: `[`Agent`](../../../com.code42.jenkins.pipelinekt.core/-agent.md)`? = null, whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../../com.code42.jenkins.pipelinekt.core/-when.md)`> = emptyList(), tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = emptyList(), options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`> = emptyList(), post: `[`Post`](../../../com.code42.jenkins.pipelinekt.core/-post/index.md)` = Post())`

A declarative stage

### Parameters

`name` - the stage name

`agent` - the optional agent definition

`steps` - the steps to execute

`post` - steps to execute after steps has completed