[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.agent](../index.md) / [Label](./index.md)

# Label

`data class Label : `[`Agent`](../../com.code42.jenkins.pipelinekt.core/-agent.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/agent/Label.kt#L7)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Label(label: Str)` |

### Properties

| Name | Summary |
|---|---|
| [label](label.md) | `val label: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [and](../../com.code42.jenkins.pipelinekt.dsl.agent/and.md) | `fun `[`Label`](./index.md)`.and(other: `[`Label`](./index.md)`): `[`Label`](./index.md) |
