[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [PublishHtml](./index.md)

# PublishHtml

`data class PublishHtml : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/PublishHtml.kt#L9)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PublishHtml(reportDir: Str, reportFiles: Str, reportName: Str, allowMissing: Bool = true.boolVar(), alwaysLinkToLastBuild: Bool = true.boolVar(), keepAll: Bool = true.boolVar())` |

### Properties

| Name | Summary |
|---|---|
| [allowMissing](allow-missing.md) | `val allowMissing: Bool` |
| [alwaysLinkToLastBuild](always-link-to-last-build.md) | `val alwaysLinkToLastBuild: Bool` |
| [keepAll](keep-all.md) | `val keepAll: Bool` |
| [reportDir](report-dir.md) | `val reportDir: Str` |
| [reportFiles](report-files.md) | `val reportFiles: Str` |
| [reportName](report-name.md) | `val reportName: Str` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
