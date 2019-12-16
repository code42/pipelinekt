[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.vars](../../index.md) / [Var](../index.md) / [Environment](./index.md)

# Environment

`data class Environment : `[`Var`](../index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/vars/Var.kt#L31)

Access an environment variable from groovy

### Parameters

`name` - the name of the environmentVar variable to use in a groovy script

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Access an environment variable from groovy`Environment(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | the name of the environmentVar variable to use in a groovy script`val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
