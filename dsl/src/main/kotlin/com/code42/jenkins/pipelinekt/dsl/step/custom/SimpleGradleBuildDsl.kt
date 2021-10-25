package com.code42.jenkins.pipelinekt.dsl.step.custom

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.step.conditional.condition
import com.code42.jenkins.pipelinekt.dsl.step.conditional.containsSubstring
import com.code42.jenkins.pipelinekt.dsl.step.declarative.bat
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withEnv

data class SimpleGradleBuildDsl(
    val shellContext: ShellContext = ShellContext.Sh,
    val gradleUserProperty: String = "gradle.wrapperUser",
    val gradlePasswordProperty: String = "gradle.wrapperPassword",
    val gradleUserPropertyValue: String = "\"\${ARTIFACTORY_USERNAME}\"",
    val gradlePasswordPropertyValue: String = "\"\${ARTIFACTORY_PASSWORD}\""
) {

    fun DslContext<Step>.gradleCommand(command: String, additionalBuildArgs: String = "") =
        gradleCommand(command, additionalBuildArgs.strDouble())

    fun DslContext<Step>.gradleCommand(command: String, additionalBuildArgs: Var.Literal.Str) =
        when (shellContext) {
            ShellContext.Sh -> gradleCommandSh(command, additionalBuildArgs)
            ShellContext.Bat -> gradleCommandBat(command, additionalBuildArgs)
            is ShellContext.Inferred -> gradleCommandMultiPlatform(command, additionalBuildArgs)
        }

    fun DslContext<Step>.gradleCommandSh(command: String, additionalBuildArgs: String = "") =
        gradleCommandSh(command, additionalBuildArgs.strDouble())

    fun DslContext<Step>.gradleCommandBat(command: String, additionalBuildArgs: String = "") =
        this.gradleCommandBat(command, additionalBuildArgs.strDouble())

    fun DslContext<Step>.gradleCommandSh(command: String, additionalBuildArgs: Var.Literal.Str) =
        withEnv(
            mapOf(
                "GRADLE_USER_HOME" to "${"WORKSPACE".environmentVar()}/.gradle-home-tmp",
                "JENKINS_NODE_COOKIE" to "dontKillMe",
                "GRADLE_OPTS" to "-D$gradleUserProperty=\'$gradleUserPropertyValue\' " +
                        "-D$gradlePasswordProperty=\'$gradlePasswordPropertyValue\'"
            )
        ) {
            sh(("./gradlew --stacktrace --build-cache $additionalBuildArgs $command").strDouble())
        }

    fun DslContext<Step>.gradleCommandBat(command: String, additionalBuildArgs: Var.Literal.Str) =
        withEnv(
            mapOf(
                "GRADLE_USER_HOME" to "${"WORKSPACE".environmentVar()}/.gradle-home-tmp",
                "JENKINS_NODE_COOKIE" to "dontKillMe",
                "GRADLE_OPTS" to "-D$gradleUserProperty=\"$gradleUserPropertyValue\" " +
                        "-D$gradlePasswordPropertyValue=\"$gradlePasswordPropertyValue\""
            )
        ) {
            bat(("call gradlew.bat --stacktrace --build-cache $additionalBuildArgs $command").strDouble())
        }

    fun DslContext<Step>.gradleCommandMultiPlatform(
        command: String,
        additionalBuildArgs: Var.Literal.Str,
        booleanStatement: BooleanStatement = "PATH".environmentVar().containsSubstring("C:".strSingle())
    ) =
        condition({ booleanStatement },
            { gradleCommandBat(command, additionalBuildArgs) },
            { gradleCommandSh(command, additionalBuildArgs) })
}
