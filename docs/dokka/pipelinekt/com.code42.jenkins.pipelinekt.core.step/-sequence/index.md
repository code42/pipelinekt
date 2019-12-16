[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.step](../index.md) / [Sequence](./index.md)

# Sequence

`data class Sequence : `[`DeclarativeStep`](../-declarative-step.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/step/Sequence.kt#L6)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Sequence(steps: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Step`](../-step/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [steps](steps.md) | `val steps: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Step`](../-step/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [andThen](and-then.md) | `fun andThen(next: `[`Step`](../-step/index.md)`): `[`Step`](../-step/index.md) |
| [any](any.md) | `fun any(fn: (`[`Step`](../-step/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [contains](contains.md) | `fun contains(other: `[`Step`](../-step/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [flatten](flatten.md) | `fun flatten(): `[`Step`](../-step/index.md) |
| [isEmpty](is-empty.md) | `fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [precededBy](preceded-by.md) | `fun precededBy(previous: `[`Step`](../-step/index.md)`): `[`Step`](../-step/index.md) |
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
