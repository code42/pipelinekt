[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.method](../index.md) / [PipelineMethodError](./index.md)

# PipelineMethodError

`sealed class PipelineMethodError : `[`RuntimeException`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-runtime-exception/index.html) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/method/PipelineMethodError.kt#L4)

### Exceptions

| Name | Summary |
|---|---|
| [DuplicateMethod](-duplicate-method/index.md) | `data class DuplicateMethod : `[`PipelineMethodError`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [cause](cause.md) | `open val cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?` |
| [message](message.md) | `open val message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
