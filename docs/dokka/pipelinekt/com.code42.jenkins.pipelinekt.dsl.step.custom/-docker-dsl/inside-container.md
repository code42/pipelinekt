[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.custom](../index.md) / [DockerDsl](index.md) / [insideContainer](./inside-container.md)

# insideContainer

`fun `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.insideContainer(dockerAgent: `[`SingletonDslContext`](../../com.code42.jenkins.pipelinekt.dsl/-singleton-dsl-context/index.md)`<`[`DockerAgent`](../../com.code42.jenkins.pipelinekt.core.agent/-docker-agent/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, sideCars: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`SideCar`](../-side-car/index.md)`> = emptyList(), steps: `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/custom/DockerDsl.kt#L44)

Run some steps inside of a container, inject "beforeContainer" and use "defaultDockerBuildArgs" if using a
docker container agent.

