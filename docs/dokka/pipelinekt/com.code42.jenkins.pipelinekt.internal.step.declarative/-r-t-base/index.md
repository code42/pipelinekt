[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [RTBase](./index.md)

# RTBase

`abstract class RTBase : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/RTBase.kt#L11)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RTBase()` |

### Properties

| Name | Summary |
|---|---|
| [buildName](build-name.md) | `abstract val buildName: Str?` |
| [buildNumber](build-number.md) | `abstract val buildNumber: Str?` |
| [failNoOp](fail-no-op.md) | `abstract val failNoOp: Bool` |
| [rtCommand](rt-command.md) | `abstract val rtCommand: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [serverID](server-i-d.md) | `abstract val serverID: Str` |
| [spec](spec.md) | `abstract val spec: `[`RTSpec`](../../com.code42.jenkins.pipelinekt.core.artifactory/-r-t-spec/index.md)`?` |
| [specPath](spec-path.md) | `abstract val specPath: Str?` |

### Functions

| Name | Summary |
|---|---|
| [rtUploadOrDownloadToGroovy](rt-upload-or-download-to-groovy.md) | `fun rtUploadOrDownloadToGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [RTDownload](../-r-t-download/index.md) | Generates the necessary code to download artifacts to Artifactory`data class RTDownload : `[`RTBase`](./index.md)`, `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [RTUpload](../-r-t-upload/index.md) | Generates the necessary code to upload artifacts to Artifactory`data class RTUpload : `[`RTBase`](./index.md)`, `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
