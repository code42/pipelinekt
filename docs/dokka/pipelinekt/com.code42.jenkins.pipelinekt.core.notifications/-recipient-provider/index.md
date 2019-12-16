[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.notifications](../index.md) / [RecipientProvider](./index.md)

# RecipientProvider

`sealed class RecipientProvider` [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/notifications/RecipientProvider.kt#L3)

### Types

| Name | Summary |
|---|---|
| [BrokenBuildSuspects](-broken-build-suspects/index.md) | `object BrokenBuildSuspects : `[`RecipientProvider`](./index.md) |
| [BrokenTestsSuspects](-broken-tests-suspects/index.md) | `object BrokenTestsSuspects : `[`RecipientProvider`](./index.md) |
| [Culprits](-culprits/index.md) | `object Culprits : `[`RecipientProvider`](./index.md) |
| [Custom](-custom/index.md) | `abstract class Custom : `[`RecipientProvider`](./index.md) |
| [Devlopers](-devlopers/index.md) | `object Devlopers : `[`RecipientProvider`](./index.md) |
| [Recipients](-recipients/index.md) | `object Recipients : `[`RecipientProvider`](./index.md) |
| [Requester](-requester/index.md) | `object Requester : `[`RecipientProvider`](./index.md) |
| [UpstreamDevelopers](-upstream-developers/index.md) | `object UpstreamDevelopers : `[`RecipientProvider`](./index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `abstract fun toGroovy(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
