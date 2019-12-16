[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.scripted](../index.md) / [docker](./index.md)

# docker

`object docker` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/scripted/DockerDsl.kt#L10)

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(image: Str, args: Str = ".".strSingle()): Build`<br>`fun build(image: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "."): Build` |
| [image](image.md) | `fun image(id: Str): Image`<br>`fun image(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Image` |
| [withRegistry](with-registry.md) | `fun withRegistry(url: Str, credentialsId: Str? = null, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithRegistry`<br>`fun withRegistry(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, credentialsId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithRegistry` |
| [withServer](with-server.md) | `fun withServer(url: Str, credentialsId: Str? = null, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithServer`<br>`fun withServer(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, credentialsId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithServer` |
| [withTool](with-tool.md) | `fun withTool(toolName: Str, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithTool`<br>`fun withTool(toolName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, steps: `[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`): WithTool` |
