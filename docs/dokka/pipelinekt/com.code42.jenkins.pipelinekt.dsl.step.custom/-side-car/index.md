[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.custom](../index.md) / [SideCar](./index.md)

# SideCar

`sealed class SideCar` [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/custom/DockerDsl.kt#L15)

### Types

| Name | Summary |
|---|---|
| [Image](-image/index.md) | `data class Image : `[`SideCar`](./index.md) |

### Properties

| Name | Summary |
|---|---|
| [containerLinkName](container-link-name.md) | `abstract val containerLinkName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [containerVariable](container-variable.md) | `abstract val containerVariable: Variable` |
| [runArgs](run-args.md) | `abstract val runArgs: Str` |
| [runCommand](run-command.md) | `abstract val runCommand: Str?` |
