[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [Node](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Node(label: Str, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)`

You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users
who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see
com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel

Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
stages don't display correctly.

### Parameters

`label` - the node label to choose

`steps` - the steps to execute on the node