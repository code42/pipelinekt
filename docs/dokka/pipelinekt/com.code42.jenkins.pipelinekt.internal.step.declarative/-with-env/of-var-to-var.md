[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [WithEnv](index.md) / [ofVarToVar](./of-var-to-var.md)

# ofVarToVar

`fun ofVarToVar(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`, `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`>, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`WithEnv`](index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/WithEnv.kt#L35)

Produces withEnv block where both environment variable name and value are inerpolated

### Parameters

`envs` - Map of environment inerpolated variable name to interpolated environment variable values