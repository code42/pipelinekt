[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [Node](./index.md)

# Node

`data class Node : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Node.kt#L20)

You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users
who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see
com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel

Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
stages don't display correctly.

### Parameters

`label` - the node label to choose

`steps` - the steps to execute on the node

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel`Node(label: Str, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [label](label.md) | the node label to choose`val label: Str` |
| [steps](steps.md) | the steps to execute on the node`val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
