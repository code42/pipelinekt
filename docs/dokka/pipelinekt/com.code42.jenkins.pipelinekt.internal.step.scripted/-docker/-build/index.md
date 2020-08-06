[pipelinekt](../../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.scripted](../../index.md) / [Docker](../index.md) / [Build](./index.md)

# Build

`data class Build : `[`Docker`](../index.md)`, ImageOps, `[`SingletonStep`](../../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Build(image: Str, args: Str = ".".strSingle())` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `val args: Str` |
| [image](image.md) | `val image: Str` |

### Functions

| Name | Summary |
|---|---|
| [scriptedGroovy](scripted-groovy.md) | `fun scriptedGroovy(writer: `[`GroovyWriter`](../../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
