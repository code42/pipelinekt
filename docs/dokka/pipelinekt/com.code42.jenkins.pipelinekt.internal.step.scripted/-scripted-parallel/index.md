[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [ScriptedParallel](./index.md)

# ScriptedParallel

`data class ScriptedParallel : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/ScriptedParallel.kt#L18)

This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism
in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.

Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
stages don't display correctly.

### Parameters

`scriptedStages` - a set of psuedo stages to execute similar to parallel stages in a declarative context.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.`ScriptedParallel(scriptedStages: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<out Str, `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [scriptedStages](scripted-stages.md) | a set of psuedo stages to execute similar to parallel stages in a declarative context.`val scriptedStages: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<out Str, `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [any](any.md) | `fun any(fn: (`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [contains](contains.md) | `fun contains(other: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isEmpty](is-empty.md) | `fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
