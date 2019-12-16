[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [RTDownload](./index.md)

# RTDownload

`data class RTDownload : `[`RTBase`](../-r-t-base/index.md)`, `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/RTDownload.kt#L21)

Generates the necessary code to download artifacts to Artifactory

### Parameters

`serverID` - the server id to download from

`buildName` - the build name

`buildNumber` - the build number

`failNoOp` - specifies whether to fail the build in case no files are downloaded

`spec` - an object representing File spec(s), which specifies the files that should be downloaded

`specPath` - path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Generates the necessary code to download artifacts to Artifactory`RTDownload(serverID: Str, buildName: Str? = null, buildNumber: Str? = null, failNoOp: Bool = false.boolVar(), spec: `[`RTSpec`](../../com.code42.jenkins.pipelinekt.core.artifactory/-r-t-spec/index.md)`? = null, specPath: Str? = null)` |

### Properties

| Name | Summary |
|---|---|
| [buildName](build-name.md) | the build name`val buildName: Str?` |
| [buildNumber](build-number.md) | the build number`val buildNumber: Str?` |
| [failNoOp](fail-no-op.md) | specifies whether to fail the build in case no files are downloaded`val failNoOp: Bool` |
| [rtCommand](rt-command.md) | `val rtCommand: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [serverID](server-i-d.md) | the server id to download from`val serverID: Str` |
| [spec](spec.md) | an object representing File spec(s), which specifies the files that should be downloaded`val spec: `[`RTSpec`](../../com.code42.jenkins.pipelinekt.core.artifactory/-r-t-spec/index.md)`?` |
| [specPath](spec-path.md) | path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)`val specPath: Str?` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
