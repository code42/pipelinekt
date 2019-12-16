[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [WithEnv](index.md) / [ofConstToVar](./of-const-to-var.md)

# ofConstToVar

`fun ofConstToVar(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`>, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`WithEnv`](index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/WithEnv.kt#L26)

Produces withEnv block where values are inerpolated

### Parameters

`envs` - Map of environment variable name to interpolated values