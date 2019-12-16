[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](./index.md)

## Package com.code42.jenkins.pipelinekt.internal.step.declarative

### Types

| Name | Summary |
|---|---|
| [ArchiveArtifacts](-archive-artifacts/index.md) | Execute archive artifacts command`data class ArchiveArtifacts : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Bat](-bat/index.md) | Execute a shell command`data class Bat : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Build](-build/index.md) | `data class Build : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [CleanWs](-clean-ws/index.md) | `object CleanWs : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Closure](-closure/index.md) | `data class Closure : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [ClosureInvocation](-closure-invocation/index.md) | `data class ClosureInvocation : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Dir](-dir/index.md) | `data class Dir : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [Echo](-echo/index.md) | Echo a string to the terminal`data class Echo : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [EmailExt](-email-ext/index.md) | Inject email into steps`data class EmailExt : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Error](-error/index.md) | `data class Error : `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md)`, `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md) |
| [InfluxDbPublisher](-influx-db-publisher/index.md) | `data class InfluxDbPublisher : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [JUnit](-j-unit/index.md) | `data class JUnit : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Literal](-literal/index.md) | Define arbitrary Declarative Jenkinsfile code blocks`data class Literal : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [PublishHtml](-publish-html/index.md) | `data class PublishHtml : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [RecordIssues](-record-issues/index.md) | `data class RecordIssues : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Retry](-retry/index.md) | `data class Retry : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [RTBase](-r-t-base/index.md) | `abstract class RTBase : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [RTDownload](-r-t-download/index.md) | Generates the necessary code to download artifacts to Artifactory`data class RTDownload : `[`RTBase`](-r-t-base/index.md)`, `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [RTUpload](-r-t-upload/index.md) | Generates the necessary code to upload artifacts to Artifactory`data class RTUpload : `[`RTBase`](-r-t-base/index.md)`, `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Sh](-sh/index.md) | Execute a shell command`data class Sh : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [SshAgent](-ssh-agent/index.md) | `data class SshAgent : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [Stash](-stash/index.md) | `data class Stash : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Tool](-tool/index.md) | `data class Tool : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Unstash](-unstash/index.md) | `data class Unstash : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [WithCredentials](-with-credentials/index.md) | Inject credentials to some steps`data class WithCredentials : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [WithEnv](-with-env/index.md) | Make environment variables available to steps`data class WithEnv : `[`DeclarativeStep`](../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`NestedStep`](../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
