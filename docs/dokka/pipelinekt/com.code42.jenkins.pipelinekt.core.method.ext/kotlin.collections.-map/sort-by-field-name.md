[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.method.ext](../index.md) / [kotlin.collections.Map](index.md) / [sortByFieldName](./sort-by-field-name.md)

# sortByFieldName

`fun <T> `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<Field, T>.sortByFieldName(): `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<Field, T>` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/method/ext/PipelineMethodExt.kt#L9)

Jenkinsfiles don't support the full groovy syntax for named arguments, sorting by
field name and always including all fields on invocation gets around this

