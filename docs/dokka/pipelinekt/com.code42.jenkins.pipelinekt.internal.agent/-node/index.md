[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.agent](../index.md) / [Node](./index.md)

# Node

`data class Node : `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/agent/Node.kt#L7)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Node(label: Str, customWorkspace: Str? = null)` |

### Properties

| Name | Summary |
|---|---|
| [customWorkspace](custom-workspace.md) | `val customWorkspace: Str?` |
| [label](label.md) | `val label: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
