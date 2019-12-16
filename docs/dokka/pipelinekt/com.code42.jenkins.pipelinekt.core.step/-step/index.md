[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.step](../index.md) / [Step](./index.md)

# Step

`interface Step : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/step/Step.kt#L5)

### Functions

| Name | Summary |
|---|---|
| [andThen](and-then.md) | `open fun andThen(next: () -> `[`Step`](./index.md)`): `[`Step`](./index.md)<br>`open fun andThen(next: `[`Step`](./index.md)`): `[`Step`](./index.md) |
| [any](any.md) | `abstract fun any(fn: (`[`Step`](./index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [contains](contains.md) | `abstract fun contains(other: `[`Step`](./index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isEmpty](is-empty.md) | `abstract fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [precededBy](preceded-by.md) | `open fun precededBy(previous: `[`Step`](./index.md)`): `[`Step`](./index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [DeclarativeStep](../-declarative-step.md) | `interface DeclarativeStep : `[`Step`](./index.md) |
| [NestedStep](../-nested-step/index.md) | `interface NestedStep : `[`Step`](./index.md) |
| [ScriptedParallel](../../com.code42.jenkins.pipelinekt.internal.step.scripted/-scripted-parallel/index.md) | This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.`data class ScriptedParallel : `[`ScriptedStep`](../-scripted-step/index.md)`, `[`Step`](./index.md) |
| [ScriptedStep](../-scripted-step/index.md) | Ensure that the pipeline is in ScriptedStep context.  These steps will not be run in the declarative context.`interface ScriptedStep : `[`Step`](./index.md) |
| [SingletonStep](../-singleton-step/index.md) | `interface SingletonStep : `[`Step`](./index.md) |
