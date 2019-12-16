[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [RecordIssues](./index.md)

# RecordIssues

`data class RecordIssues : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/RecordIssues.kt#L10)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RecordIssues(aggregatingResults: Bool = false.boolVar(), tool: `[`RecordIssuesTool`](../../com.code42.jenkins.pipelinekt.core.issues/-record-issues-tool/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [aggregatingResults](aggregating-results.md) | `val aggregatingResults: Bool` |
| [tool](tool.md) | `val tool: `[`RecordIssuesTool`](../../com.code42.jenkins.pipelinekt.core.issues/-record-issues-tool/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
