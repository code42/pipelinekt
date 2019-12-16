[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [WithEnv](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`WithEnv(envs: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = emptyMap(), steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`)`

Make environment variables available to steps

Does not use Var.Literal.Str because quotes are not needed in this bit of groovy.  It isn't a literal var

**Envs**
the environment variables to inject.

**Steps**
the steps that can use the environment variables

