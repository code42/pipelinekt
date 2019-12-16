[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.core](index.md) / [Agent](./-agent.md)

# Agent

`interface Agent : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/Agent.kt#L5)

### Inheritors

| Name | Summary |
|---|---|
| [Any](../com.code42.jenkins.pipelinekt.internal.agent/-any/index.md) | `object Any : `[`Agent`](./-agent.md) |
| [DockerAgent](../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md) | `sealed class DockerAgent : `[`Agent`](./-agent.md) |
| [Label](../com.code42.jenkins.pipelinekt.internal.agent/-label/index.md) | `data class Label : `[`Agent`](./-agent.md) |
| [Node](../com.code42.jenkins.pipelinekt.internal.agent/-node/index.md) | `data class Node : `[`Agent`](./-agent.md) |
| [None](../com.code42.jenkins.pipelinekt.internal.agent/-none/index.md) | `object None : `[`Agent`](./-agent.md) |
