[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../index.md) / [Docker](./index.md)

# Docker

`sealed class Docker : `[`ScriptedStep`](../../com.code42.jenkins.pipelinekt.core.step/-scripted-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/scripted/Docker.kt#L14)

### Types

| Name | Summary |
|---|---|
| [Build](-build/index.md) | `data class Build : `[`Docker`](./index.md)`, ImageOps, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [Image](-image/index.md) | `data class Image : `[`Docker`](./index.md)`, ImageOps, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) |
| [ImageOps](-image-ops/index.md) | `interface ImageOps : `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md) |
| [WithRegistry](-with-registry/index.md) | `data class WithRegistry : `[`Docker`](./index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [WithServer](-with-server/index.md) | `data class WithServer : `[`Docker`](./index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
| [WithTool](-with-tool/index.md) | `data class WithTool : `[`Docker`](./index.md)`, `[`NestedStep`](../../com.code42.jenkins.pipelinekt.core.step/-nested-step/index.md) |
