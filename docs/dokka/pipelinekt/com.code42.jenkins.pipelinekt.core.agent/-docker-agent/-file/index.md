[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.core.agent](../../index.md) / [DockerAgent](../index.md) / [File](./index.md)

# File

`data class File : `[`DockerAgent`](../index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `File(filename: Str, dir: Str? = null, additionalBuildArgs: Str? = null, args: Str? = null, label: Str? = null, customWorkspace: Str? = null, registryUrl: Str? = null, registryCredentialsId: Str? = null, reuseNode: Bool? = null)` |

### Properties

| Name | Summary |
|---|---|
| [additionalBuildArgs](additional-build-args.md) | `val additionalBuildArgs: Str?` |
| [args](args.md) | `val args: Str?` |
| [customWorkspace](custom-workspace.md) | `val customWorkspace: Str?` |
| [dir](dir.md) | `val dir: Str?` |
| [filename](filename.md) | `val filename: Str` |
| [label](label.md) | `val label: Str?` |
| [registryCredentialsId](registry-credentials-id.md) | `val registryCredentialsId: Str?` |
| [registryUrl](registry-url.md) | `val registryUrl: Str?` |
| [reuseNode](reuse-node.md) | `val reuseNode: Bool?` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
