[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../../index.md) / [Docker](../index.md) / [ImageOps](./index.md)

# ImageOps

`interface ImageOps : `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Docker.kt#L15)

### Types

| Name | Summary |
|---|---|
| [Inside](-inside/index.md) | `data class Inside : `[`Docker`](../index.md)`, `[`NestedStep`](../../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [Pull](-pull/index.md) | `object Pull : `[`Docker`](../index.md)`, `[`SingletonStep`](../../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Push](-push/index.md) | `data class Push : `[`Docker`](../index.md)`, `[`SingletonStep`](../../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Run](-run/index.md) | `data class Run : `[`Docker`](../index.md)`, `[`SingletonStep`](../../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Tag](-tag/index.md) | `data class Tag : `[`Docker`](../index.md)`, `[`SingletonStep`](../../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [WithRun](-with-run/index.md) | `data class WithRun : `[`Docker`](../index.md)`, `[`NestedStep`](../../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |

### Functions

| Name | Summary |
|---|---|
| [inside](inside.md) | `open fun inside(args: Str = "".strSingle(), steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [pull](pull.md) | `open fun pull(): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [push](push.md) | `open fun push(tagName: Str? = null, force: Bool = true.boolVar()): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [run](run.md) | `open fun run(args: Str = "".strSingle(), command: Str = "".strDouble()): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [tag](tag.md) | `open fun tag(tagName: Str? = null, force: Bool = true.boolVar()): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [withRun](with-run.md) | `open fun withRun(args: Str = "".strSingle(), command: Str? = null, steps: `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`, containerVariable: Variable = "container".groovyVariable()): `[`Step`](../../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
