[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.option](../index.md) / [Timeout](./index.md)

# Timeout

`data class Timeout : `[`StageOption`](../../com.code42.jenkins.pipelinekt.core/-stage-option.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/option/Timeout.kt#L8)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Timeout(time: Int, unit: `[`TimeUnit`](https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [time](time.md) | `val time: Int` |
| [unit](unit.md) | `val unit: `[`TimeUnit`](https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/TimeUnit.html) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
