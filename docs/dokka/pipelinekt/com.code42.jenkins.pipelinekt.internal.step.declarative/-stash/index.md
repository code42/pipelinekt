[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.internal.step.declarative](../index.md) / [Stash](./index.md)

# Stash

`data class Stash : `[`DeclarativeStep`](../../com.code42.jenkins.pipelinekt.core.step/-declarative-step.md)`, `[`SingletonStep`](../../com.code42.jenkins.pipelinekt.core.step/-singleton-step/index.md) [(source)](https://github.com/code42/pipelinekt/tree/master/internal/src/main/kotlin/com/code42/jenkins/pipelinekt/internal/step/declarative/Stash.kt#L10)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Stash(name: Str, allowEmpty: Bool? = null, excludes: Str? = null, includes: Str? = null, useDefaultExcludes: Bool? = null)` |

### Properties

| Name | Summary |
|---|---|
| [allowEmpty](allow-empty.md) | `val allowEmpty: Bool?` |
| [excludes](excludes.md) | `val excludes: Str?` |
| [includes](includes.md) | `val includes: Str?` |
| [name](name.md) | `val name: Str` |
| [useDefaultExcludes](use-default-excludes.md) | `val useDefaultExcludes: Bool?` |

### Functions

| Name | Summary |
|---|---|
| [toGroovy](to-groovy.md) | `fun toGroovy(writer: `[`GroovyWriter`](../../com.code42.jenkins.pipelinekt.core.writer/-groovy-writer/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
