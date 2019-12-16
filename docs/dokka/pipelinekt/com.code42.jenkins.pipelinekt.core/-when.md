[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.core](index.md) / [When](./-when.md)

# When

`interface When : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/When.kt#L5)

### Inheritors

| Name | Summary |
|---|---|
| [AllOf](../com.code42.jenkins.pipelinekt.internal.when/-all-of/index.md) | `data class AllOf : `[`When`](./-when.md) |
| [AnyOf](../com.code42.jenkins.pipelinekt.internal.when/-any-of/index.md) | `data class AnyOf : `[`When`](./-when.md) |
| [Before](../com.code42.jenkins.pipelinekt.internal.when/-before/index.md) | `sealed class Before : `[`When`](./-when.md) |
| [Branch](../com.code42.jenkins.pipelinekt.internal.when/-branch/index.md) | `sealed class Branch : `[`When`](./-when.md) |
| [BuildingTag](../com.code42.jenkins.pipelinekt.internal.when/-building-tag/index.md) | `object BuildingTag : `[`When`](./-when.md) |
| [Changelog](../com.code42.jenkins.pipelinekt.internal.when/-changelog/index.md) | `data class Changelog : `[`When`](./-when.md) |
| [ChangeRequest](../com.code42.jenkins.pipelinekt.internal.when/-change-request/index.md) | `sealed class ChangeRequest : `[`When`](./-when.md) |
| [ChangeSet](../com.code42.jenkins.pipelinekt.internal.when/-change-set/index.md) | `data class ChangeSet : `[`When`](./-when.md) |
| [Environment](../com.code42.jenkins.pipelinekt.internal.when/-environment/index.md) | `data class Environment : `[`When`](./-when.md) |
| [Equals](../com.code42.jenkins.pipelinekt.internal.when/-equals/index.md) | `data class Equals : `[`When`](./-when.md) |
| [Expression](../com.code42.jenkins.pipelinekt.internal.when/-expression/index.md) | `data class Expression : `[`When`](./-when.md) |
| [Literal](../com.code42.jenkins.pipelinekt.internal.when/-literal/index.md) | `data class Literal : `[`When`](./-when.md) |
| [Not](../com.code42.jenkins.pipelinekt.internal.when/-not/index.md) | `data class Not : `[`When`](./-when.md) |
| [Tag](../com.code42.jenkins.pipelinekt.internal.when/-tag/index.md) | `sealed class Tag : `[`When`](./-when.md) |
| [TriggeredBy](../com.code42.jenkins.pipelinekt.internal.when/-triggered-by/index.md) | `data class TriggeredBy : `[`When`](./-when.md) |
