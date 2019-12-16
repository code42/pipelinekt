[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.writer](../index.md) / [GroovyWriter](./index.md)

# GroovyWriter

`data class GroovyWriter` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/writer/GroovyWriter.kt#L30)

Writes a GroovyScript to a PrintWriter.

### Parameters

`writer` - destination to write to.

`indent` - the level of indent, initizlized to 0

`context` - declarative or scripted

`indentStr` -

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Writes a GroovyScript to a PrintWriter.`GroovyWriter(writer: `[`PrintWriter`](https://docs.oracle.com/javase/6/docs/api/java/io/PrintWriter.html)`, indent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, context: `[`Context`](../-context/index.md)` = Context.Declarative, indentStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "  ")` |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | declarative or scripted`val context: `[`Context`](../-context/index.md) |
| [indent](indent.md) | the level of indent, initizlized to 0`val indent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [indentStr](indent-str.md) | `val indentStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [writer](writer.md) | destination to write to.`val writer: `[`PrintWriter`](https://docs.oracle.com/javase/6/docs/api/java/io/PrintWriter.html) |

### Functions

| Name | Summary |
|---|---|
| [closure](closure.md) | Write a groovy step to the writer, will look like`fun closure(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: (`[`GroovyWriter`](./index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, param: Variable): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun closure(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: (`[`GroovyWriter`](./index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Write a closure to the output.  will look like`fun closure(prefix: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, body: (`[`GroovyWriter`](./index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, param: Variable?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun closure(prefix: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, body: (`[`GroovyWriter`](./index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [inner](inner.md) | Return a new GroovyWRiter that writes at one level of nested indentation`fun inner(): `[`GroovyWriter`](./index.md) |
| [scripted](scripted.md) | ensure scripted context`fun scripted(body: (`[`GroovyWriter`](./index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [writeln](writeln.md) | Write a ln to the output`fun writeln(string: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [forFile](for-file.md) | `fun forFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, indentStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "  "): `[`GroovyWriter`](./index.md) |
