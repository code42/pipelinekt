[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.step](../index.md) / [NestedStep](./index.md)

# NestedStep

`interface NestedStep : `[`Step`](../-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/step/NestedStep.kt#L3)

### Properties

| Name | Summary |
|---|---|
| [steps](steps.md) | `abstract val steps: `[`Step`](../-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [any](any.md) | `open fun any(fn: (`[`Step`](../-step/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [contains](contains.md) | `open fun contains(other: `[`Step`](../-step/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isEmpty](is-empty.md) | `open fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Closure](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-closure/index.md) | `data class Closure : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
| [Dir](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-dir/index.md) | `data class Dir : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
| [If](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-if/index.md) | `data class If : `[`ScriptedStep`](../-scripted-step/index.md)`, `[`NestedStep`](./index.md) |
| [Node](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-node/index.md) | You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel`data class Node : `[`ScriptedStep`](../-scripted-step/index.md)`, `[`NestedStep`](./index.md) |
| [Retry](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-retry/index.md) | `data class Retry : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
| [SshAgent](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-ssh-agent/index.md) | `data class SshAgent : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
| [VariableAssignment](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-variable-assignment/index.md) | Declare a variable and assign it to the output of some steps`data class VariableAssignment : `[`ScriptedStep`](../-scripted-step/index.md)`, `[`NestedStep`](./index.md) |
| [WithCredentials](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-with-credentials/index.md) | Inject credentials to some steps`data class WithCredentials : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
| [WithEnv](../../com.code42.jenkins.pipelinekt.internal.step.declarative/-with-env/index.md) | Make environment variables available to steps`data class WithEnv : `[`DeclarativeStep`](../-declarative-step.md)`, `[`NestedStep`](./index.md) |
