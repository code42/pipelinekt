[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](./index.md)

## Package com.code42.jenkins.pipelinekt.internal.step.scripted

### Types

| Name | Summary |
|---|---|
| [Docker](-docker/index.md) | `sealed class Docker : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md) |
| [If](-if/index.md) | `data class If : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [Literal](-literal/index.md) | Define arbitrary scripted Jenkinsfile code blocks`data class Literal : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Node](-node/index.md) | You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel`data class Node : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [NotifyBitbucket](-notify-bitbucket/index.md) | Notify Bitbucket server of build status.  Use at the beginning and end of a pipeline.`object NotifyBitbucket : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [ReadProperties](-read-properties/index.md) | `data class ReadProperties : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [ScriptedParallel](-scripted-parallel/index.md) | This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.`data class ScriptedParallel : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`Step`](../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [VariableAssignment](-variable-assignment/index.md) | Declare a variable and assign it to the output of some steps`data class VariableAssignment : `[`ScriptedStep`](../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
