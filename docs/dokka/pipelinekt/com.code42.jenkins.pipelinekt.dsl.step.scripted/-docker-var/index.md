[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.scripted](../index.md) / [DockerVar](./index.md)

# DockerVar

`data class DockerVar : External` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/scripted/DockerDsl.kt#L13)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DockerVar(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, context: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [inside](inside.md) | `fun inside(args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [push](push.md) | `fun push(tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [run](run.md) | `fun run(args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", command: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = ""): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [tag](tag.md) | `fun tag(tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toGroovy](to-groovy.md) | `fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [withRun](with-run.md) | `fun withRun(args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", command: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", containerVariable: Variable = "container".groovyVariable(), steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun withRun(args: Str, command: Str?, containerVariable: Variable, steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [&amp;&amp;](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/&&.md) | `infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.&&(other: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.&&(other: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [==](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/==.md) | `infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.==(other: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.==(other: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [containsSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/contains-substring.md) | `fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.containsSubstring(subString: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): Contains`<br>`fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.containsSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Contains` |
| [endsWithSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/ends-with-substring.md) | `fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.endsWithSubstring(subString: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): EndsWith`<br>`fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.endsWithSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): EndsWith` |
| [startsWithSubstring](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/starts-with-substring.md) | `fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.startsWithSubstring(subString: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): StartsWith`<br>`fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.startsWithSubstring(subString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): StartsWith` |
| [statement](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/statement.md) | `fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.statement(): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
| [||](../../com.code42.jenkins.pipelinekt.dsl.step.conditional/||.md) | `infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.||(other: `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)<br>`infix fun `[`Var`](../../com.code42.jenkins.pipelinekt.core.vars/-var/index.md)`.||(other: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)`): `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md) |
