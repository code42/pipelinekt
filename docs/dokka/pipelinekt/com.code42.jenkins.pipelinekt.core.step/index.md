[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.core.step](./index.md)

## Package com.code42.jenkins.pipelinekt.core.step

### Types

| Name | Summary |
|---|---|
| [DeclarativeStep](-declarative-step.md) | `interface DeclarativeStep : `[`Step`](-step/index.md) |
| [NestedStep](-nested-step/index.md) | `interface NestedStep : `[`Step`](-step/index.md) |
| [ScriptedStep](-scripted-step/index.md) | Ensure that the pipeline is in ScriptedStep context.  These steps will not be run in the declarative context.`interface ScriptedStep : `[`Step`](-step/index.md) |
| [Sequence](-sequence/index.md) | `data class Sequence : `[`DeclarativeStep`](-declarative-step.md) |
| [SingletonStep](-singleton-step/index.md) | `interface SingletonStep : `[`Step`](-step/index.md) |
| [Step](-step/index.md) | `interface Step : `[`GroovyScript`](../com.code42.jenkins.pipelinekt.core.writer/-groovy-script/index.md) |
| [Void](-void/index.md) | An empty step`object Void : `[`DeclarativeStep`](-declarative-step.md)`, `[`SingletonStep`](-singleton-step/index.md) |
