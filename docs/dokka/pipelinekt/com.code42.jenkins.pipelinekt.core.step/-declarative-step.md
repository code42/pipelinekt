[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.core.step](index.md) / [DeclarativeStep](./-declarative-step.md)

# DeclarativeStep

`interface DeclarativeStep : `[`Step`](-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/core/src/main/kotlin/com/code42/jenkins/pipelinekt/core/step/DeclarativeStep.kt#L3)

### Inheritors

| Name | Summary |
|---|---|
| [ArchiveArtifacts](../com.code42.jenkins.pipelinekt.internal.step.declarative/-archive-artifacts/index.md) | Execute archive artifacts command`data class ArchiveArtifacts : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Bat](../com.code42.jenkins.pipelinekt.internal.step.declarative/-bat/index.md) | Execute a shell command`data class Bat : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Build](../com.code42.jenkins.pipelinekt.internal.step.declarative/-build/index.md) | `data class Build : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [CleanWs](../com.code42.jenkins.pipelinekt.internal.step.declarative/-clean-ws/index.md) | `object CleanWs : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Closure](../com.code42.jenkins.pipelinekt.internal.step.declarative/-closure/index.md) | `data class Closure : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
| [ClosureInvocation](../com.code42.jenkins.pipelinekt.internal.step.declarative/-closure-invocation/index.md) | `data class ClosureInvocation : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Dir](../com.code42.jenkins.pipelinekt.internal.step.declarative/-dir/index.md) | `data class Dir : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
| [Echo](../com.code42.jenkins.pipelinekt.internal.step.declarative/-echo/index.md) | Echo a string to the terminal`data class Echo : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [EmailExt](../com.code42.jenkins.pipelinekt.internal.step.declarative/-email-ext/index.md) | Inject email into steps`data class EmailExt : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Error](../com.code42.jenkins.pipelinekt.internal.step.declarative/-error/index.md) | `data class Error : `[`SingletonStep`](-singleton-step/index.md)`, `[`DeclarativeStep`](./-declarative-step.md) |
| [InfluxDbPublisher](../com.code42.jenkins.pipelinekt.internal.step.declarative/-influx-db-publisher/index.md) | `data class InfluxDbPublisher : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [JUnit](../com.code42.jenkins.pipelinekt.internal.step.declarative/-j-unit/index.md) | `data class JUnit : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Literal](../com.code42.jenkins.pipelinekt.internal.step.declarative/-literal/index.md) | Define arbitrary Declarative Jenkinsfile code blocks`data class Literal : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [PipelineMethodInvocation](../com.code42.jenkins.pipelinekt.core.method/-pipeline-method-invocation/index.md) | `data class PipelineMethodInvocation : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [PublishHtml](../com.code42.jenkins.pipelinekt.internal.step.declarative/-publish-html/index.md) | `data class PublishHtml : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [RecordIssues](../com.code42.jenkins.pipelinekt.internal.step.declarative/-record-issues/index.md) | `data class RecordIssues : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Retry](../com.code42.jenkins.pipelinekt.internal.step.declarative/-retry/index.md) | `data class Retry : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
| [RTBase](../com.code42.jenkins.pipelinekt.internal.step.declarative/-r-t-base/index.md) | `abstract class RTBase : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [RTDownload](../com.code42.jenkins.pipelinekt.internal.step.declarative/-r-t-download/index.md) | Generates the necessary code to download artifacts to Artifactory`data class RTDownload : `[`RTBase`](../com.code42.jenkins.pipelinekt.internal.step.declarative/-r-t-base/index.md)`, `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [RTUpload](../com.code42.jenkins.pipelinekt.internal.step.declarative/-r-t-upload/index.md) | Generates the necessary code to upload artifacts to Artifactory`data class RTUpload : `[`RTBase`](../com.code42.jenkins.pipelinekt.internal.step.declarative/-r-t-base/index.md)`, `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Sequence](-sequence/index.md) | `data class Sequence : `[`DeclarativeStep`](./-declarative-step.md) |
| [Sh](../com.code42.jenkins.pipelinekt.internal.step.declarative/-sh/index.md) | Execute a shell command`data class Sh : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [SshAgent](../com.code42.jenkins.pipelinekt.internal.step.declarative/-ssh-agent/index.md) | `data class SshAgent : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
| [Stash](../com.code42.jenkins.pipelinekt.internal.step.declarative/-stash/index.md) | `data class Stash : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Tool](../com.code42.jenkins.pipelinekt.internal.step.declarative/-tool/index.md) | `data class Tool : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Unstash](../com.code42.jenkins.pipelinekt.internal.step.declarative/-unstash/index.md) | `data class Unstash : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [Void](-void/index.md) | An empty step`object Void : `[`DeclarativeStep`](./-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
| [WithCredentials](../com.code42.jenkins.pipelinekt.internal.step.declarative/-with-credentials/index.md) | Inject credentials to some steps`data class WithCredentials : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
| [WithEnv](../com.code42.jenkins.pipelinekt.internal.step.declarative/-with-env/index.md) | Make environment variables available to steps`data class WithEnv : `[`DeclarativeStep`](./-declarative-step.md)`, `[`NestedStep`](-nested-step/index.md) |
