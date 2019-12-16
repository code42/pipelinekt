[pipelinekt](../index.md) / [com.code42.jenkins.pipelinekt.dsl.step.scripted](index.md) / [inParallel](./in-parallel.md)

# inParallel

`fun `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.inParallel(scriptedStages: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`DslContext`](../com.code42.jenkins.pipelinekt.dsl/-dsl-context/index.md)`<`[`Step`](../com.code42.jenkins.pipelinekt.core.step/-step/index.md)`>.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/code42/pipelinekt/tree/master/dsl/src/main/kotlin/com/code42/jenkins/pipelinekt/dsl/step/scripted/ScriptedParallelDsl.kt#L19)

Executes some steps in parallel

Warning, please read the docs before using this.

At the time of writing, you cannot run nested parallel blocks
https://issues.jenkins-ci.org/browse/JENKINS-54010?page=com.atlassian.jira.plugin.system.issuetabpanels%3Achangehistory-tabpanel

This implements the workaround documented by CloudBees here: https://support.cloudbees.com/hc/en-us/articles/115000088431-Create-a-Matrix-like-flow-with-Pipeline

