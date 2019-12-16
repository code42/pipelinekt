[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [NestedStageContext](index.md) / [parallel](./parallel.md)

# parallel

`open fun ~~parallel~~(stagesBlock: `[`StageWrapperContext`](../-stage-wrapper-context/index.md)`<`[`NestedStageContext`](index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/NestedStageContext.kt#L39)
**Deprecated:** Nested Parallel stages not Implemented in Jenkins

This method is here to prevent calling parallel in nested stages.  This method should never be invoked.

Parallel stages are only valid from the top level

