[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.core.agent](../index.md) / [DockerAgent](./index.md)

# DockerAgent

`sealed class DockerAgent : `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/agent/DockerAgent.kt#L7)

### Types

| Name | Summary |
|---|---|
| [File](-file/index.md) | `data class File : `[`DockerAgent`](./index.md) |
| [Image](-image/index.md) | `data class Image : `[`DockerAgent`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `abstract val args: Str?` |
| [customWorkspace](custom-workspace.md) | `abstract val customWorkspace: Str?` |
| [label](label.md) | `abstract val label: Str?` |
| [registryCredentialsId](registry-credentials-id.md) | `abstract val registryCredentialsId: Str?` |
| [registryUrl](registry-url.md) | `abstract val registryUrl: Str?` |
| [reuseNode](reuse-node.md) | `abstract val reuseNode: Bool?` |
