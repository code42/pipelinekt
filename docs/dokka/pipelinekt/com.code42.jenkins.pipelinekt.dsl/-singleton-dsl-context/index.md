[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl](../index.md) / [SingletonDslContext](./index.md)

# SingletonDslContext

`open class SingletonDslContext<T>` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/DslContext.kt#L30)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SingletonDslContext(items: `[`Queue`](https://docs.oracle.com/javase/6/docs/api/java/util/Queue.html)`<T> = (LinkedBlockingQueue(1)))` |

### Properties

| Name | Summary |
|---|---|
| [items](items.md) | `val items: `[`Queue`](https://docs.oracle.com/javase/6/docs/api/java/util/Queue.html)`<T>` |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(item: T): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drainAll](drain-all.md) | `fun drainAll(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<T>` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [into](into.md) | `fun <T> into(block: `[`SingletonDslContext`](./index.md)`<T>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): T?` |

### Extension Functions

| Name | Summary |
|---|---|
| [dockerFile](../../com.code42.jenkins.pipelinekt.dsl.agent/docker-file.md) | `fun `[`SingletonDslContext`](./index.md)`<in `[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.dockerFile(filename: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, dir: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, additionalBuildArgs: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, customWorkspace: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, registryUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, registryCredentialsId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, reuseNode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`SingletonDslContext`](./index.md)`<in `[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.dockerFile(filename: Str, dir: Str? = null, additionalBuildArgs: Str? = null, args: Str? = null, label: Str? = null, customWorkspace: Str? = null, registryUrl: Str? = null, registryCredentialsId: Str? = null, reuseNode: Bool? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [dockerImage](../../com.code42.jenkins.pipelinekt.dsl.agent/docker-image.md) | `fun `[`SingletonDslContext`](./index.md)`<in `[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.dockerImage(image: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, customWorkspace: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, registryUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, registryCredentialsId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, reuseNode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`SingletonDslContext`](./index.md)`<in `[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.dockerImage(image: Str, args: Str? = null, label: Str? = null, customWorkspace: Str? = null, registryUrl: Str? = null, registryCredentialsId: Str? = null, reuseNode: Bool? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [label](../../com.code42.jenkins.pipelinekt.dsl.agent/label.md) | `fun `[`SingletonDslContext`](./index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.label(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`SingletonDslContext`](./index.md)`<`[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md)`>.label(name: Str): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
