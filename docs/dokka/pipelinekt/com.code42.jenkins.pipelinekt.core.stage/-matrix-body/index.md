[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.stage](../index.md) / [MatrixBody](./index.md)

# MatrixBody

`data class MatrixBody : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/stage/MatrixBody.kt#L12)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MatrixBody(axes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MatrixAxis`](../-matrix-axis/index.md)`>, excludes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MatrixExclude`](../-matrix-exclude/index.md)`>, stages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Stage`](../-stage/index.md)`>, agent: `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`? = null, whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`> = emptyList(), tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`> = emptyList(), options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`> = emptyList(), post: `[`Post`](../../com.code42.jenkins.pipelinekt.core/-post/index.md)` = Post())` |

### Properties

| Name | Summary |
|---|---|
| [agent](agent.md) | `val agent: `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`?` |
| [axes](axes.md) | `val axes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MatrixAxis`](../-matrix-axis/index.md)`>` |
| [excludes](excludes.md) | `val excludes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MatrixExclude`](../-matrix-exclude/index.md)`>` |
| [options](options.md) | `val options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md)`>` |
| [post](post.md) | `val post: `[`Post`](../../com.code42.jenkins.pipelinekt.core/-post/index.md) |
| [stages](stages.md) | `val stages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Stage`](../-stage/index.md)`>` |
| [tools](tools.md) | `val tools: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Tool`](../../com.code42.jenkins.pipelinekt.core/-tool.md)`>` |
| [whenBlock](when-block.md) | `val whenBlock: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`When`](../../com.code42.jenkins.pipelinekt.core/-when.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
