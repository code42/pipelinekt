[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.custom](../index.md) / [DockerDsl](./index.md)

# DockerDsl

`data class DockerDsl` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/custom/DockerDsl.kt#L36)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DockerDsl(defaultDockerBuildArgs: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, beforeContainer: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [beforeContainer](before-container.md) | `val beforeContainer: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [defaultDockerBuildArgs](default-docker-build-args.md) | `val defaultDockerBuildArgs: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [insideContainer](inside-container.md) | Run some steps inside of a container, inject "beforeContainer" and use "defaultDockerBuildArgs" if using a docker container agent.`fun `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.insideContainer(dockerAgent: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, sideCars: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SideCar`](../-side-car/index.md)`> = emptyList(), steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
