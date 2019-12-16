[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [WithEnv](./index.md)

# WithEnv

`data class WithEnv : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/WithEnv.kt#L18)

Make environment variables available to steps

Does not use Var.Literal.Str because quotes are not needed in this bit of groovy.  It isn't a literal var

**Envs**
the environment variables to inject.

**Steps**
the steps that can use the environment variables

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Make environment variables available to steps`WithEnv(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = emptyMap(), steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [envs](envs.md) | `val envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [steps](steps.md) | `val steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [ofConstToVar](of-const-to-var.md) | Produces withEnv block where values are inerpolated`fun ofConstToVar(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`>, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`WithEnv`](./index.md) |
| [ofVarToVar](of-var-to-var.md) | Produces withEnv block where both environment variable name and value are inerpolated`fun ofVarToVar(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`, `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`>, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`WithEnv`](./index.md) |
