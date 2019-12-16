[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [MatrixExcludeAxisContext](./index.md)

# MatrixExcludeAxisContext

`data class MatrixExcludeAxisContext : `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`ExcludeAxis`](../../com.code42.jenkins.pipelinekt.core.stage/-exclude-axis/index.md)`>` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/MatrixExcludeAxisContext.kt#L10)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MatrixExcludeAxisContext(excludeAxes: `[`Queue`](https://docs.oracle.com/javase/6/docs/api/java/util/Queue.html)`<`[`ExcludeAxis`](../../com.code42.jenkins.pipelinekt.core.stage/-exclude-axis/index.md)`> = LinkedBlockingQueue())` |

### Properties

| Name | Summary |
|---|---|
| [excludeAxes](exclude-axes.md) | `val excludeAxes: `[`Queue`](https://docs.oracle.com/javase/6/docs/api/java/util/Queue.html)`<`[`ExcludeAxis`](../../com.code42.jenkins.pipelinekt.core.stage/-exclude-axis/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [axis](axis.md) | `fun axis(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, values: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun axis(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, values: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun axis(name: Str, values: Str): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun axis(name: Str, values: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Str>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [notAxis](not-axis.md) | `fun notAxis(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, notValues: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun notAxis(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, notValues: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun notAxis(name: Str, notValues: Str): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun notAxis(name: Str, notValues: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Str>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [into](../../com.code42.jenkins.pipelinekt.dsl/into.md) | `fun <T, Dsl : `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<T>> Dsl.into(block: Dsl.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>` |
