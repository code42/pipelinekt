[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.stage](../index.md) / [NestedStageContext](index.md) / [matrix](./matrix.md)

# matrix

`open fun matrix(matrixBlock: `[`MatrixContext`](../-matrix-context/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/stage/NestedStageContext.kt#L48)

This method is here to prevent calling parallel in nested stages.  This method should never be invoked.

Matrix stages are only valid from the top level

