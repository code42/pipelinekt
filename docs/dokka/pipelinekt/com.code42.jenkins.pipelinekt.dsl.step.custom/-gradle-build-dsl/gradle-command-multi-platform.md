[pipelinekt](../../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.custom](../index.md) / [GradleBuildDsl](index.md) / [gradleCommandMultiPlatform](./gradle-command-multi-platform.md)

# gradleCommandMultiPlatform

`fun `[`DslContext`](../../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.gradleCommandMultiPlatform(command: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, additionalBuildArgs: Str, booleanStatement: `[`BooleanStatement`](../../com.code42.jenkins.pipelinekt.core.conditional/-boolean-statement/index.md)` = "PATH".environmentVar().containsSubstring("C:".strSingle())): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)