[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [ArchiveArtifacts](./index.md)

# ArchiveArtifacts

`data class ArchiveArtifacts : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/ArchiveArtifacts.kt#L14)

Execute archive artifacts command

### Parameters

`artifacts` - the artifacts to archive, blob pattern

`fingerprint` - whether the artifact is part of the archives fingerprints

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Execute archive artifacts command`ArchiveArtifacts(artifacts: Str, fingerprint: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false)` |

### Properties

| Name | Summary |
|---|---|
| [artifacts](artifacts.md) | the artifacts to archive, blob pattern`val artifacts: Str` |
| [fingerprint](fingerprint.md) | whether the artifact is part of the archives fingerprints`val fingerprint: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
