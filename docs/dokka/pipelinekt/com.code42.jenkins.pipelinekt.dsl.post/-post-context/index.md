[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.post](../index.md) / [PostContext](./index.md)

# PostContext

`class PostContext` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/post/PostContext.kt#L8)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PostContext(alwaysContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`> = DslContext(), successContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`> = DslContext(), cleanupContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`> = DslContext())` |

### Properties

| Name | Summary |
|---|---|
| [alwaysContext](always-context.md) | `val alwaysContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |
| [cleanupContext](cleanup-context.md) | `val cleanupContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |
| [successContext](success-context.md) | `val successContext: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [always](always.md) | `fun always(alwaysBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cleanup](cleanup.md) | `fun cleanup(cleanupBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [success](success.md) | `fun success(successBlock: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toPost](to-post.md) | `fun toPost(): `[`Post`](../../com.code42.jenkins.pipelinekt.core/-post/index.md) |
