[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core](../index.md) / [Cause](./index.md)

# Cause

`sealed class Cause` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/Cause.kt#L5)

### Types

| Name | Summary |
|---|---|
| [SCMTrigger](-s-c-m-trigger/index.md) | `object SCMTrigger : `[`Cause`](./index.md) |
| [TimerTrigger](-timer-trigger/index.md) | `object TimerTrigger : `[`Cause`](./index.md) |
| [UpstreamCause](-upstream-cause/index.md) | `object UpstreamCause : `[`Cause`](./index.md) |
| [UserIdCause](-user-id-cause/index.md) | `data class UserIdCause : `[`Cause`](./index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
