[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core](../index.md) / [Post](./index.md)

# Post

`data class Post : `[`GroovyScript`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/Post.kt#L8)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Post(always: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, success: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, cleanup: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, changed: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, fixed: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, regression: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, aborted: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, unsuccessful: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, unstable: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void, failure: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)` = Void)` |

### Properties

| Name | Summary |
|---|---|
| [aborted](aborted.md) | `val aborted: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [always](always.md) | `val always: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [changed](changed.md) | `val changed: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [cleanup](cleanup.md) | `val cleanup: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [failure](failure.md) | `val failure: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [fixed](fixed.md) | `val fixed: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [regression](regression.md) | `val regression: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [success](success.md) | `val success: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [unstable](unstable.md) | `val unstable: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [unsuccessful](unsuccessful.md) | `val unsuccessful: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [merge](merge.md) | `fun merge(other: `[`Post`](./index.md)`): `[`Post`](./index.md) |
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
