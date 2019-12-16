[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [ScriptedParallel](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ScriptedParallel(scriptedStages: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<out Str, `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>)`

This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism
in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.

Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
stages don't display correctly.

### Parameters

`scriptedStages` - a set of psuedo stages to execute similar to parallel stages in a declarative context.