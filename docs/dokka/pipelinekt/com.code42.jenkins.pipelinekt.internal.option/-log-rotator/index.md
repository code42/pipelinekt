[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.option](../index.md) / [LogRotator](./index.md)

# LogRotator

`data class LogRotator : `[`BuildDiscarder`](../../com.code42.jenkins.pipelinekt.core.option/-build-discarder.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/option/LogRotator.kt#L6)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LogRotator(numToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, daysToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, artifactsNumToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, artifactDaysToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [artifactDaysToKeep](artifact-days-to-keep.md) | `val artifactDaysToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [artifactsNumToKeep](artifacts-num-to-keep.md) | `val artifactsNumToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [daysToKeep](days-to-keep.md) | `val daysToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [numToKeep](num-to-keep.md) | `val numToKeep: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
