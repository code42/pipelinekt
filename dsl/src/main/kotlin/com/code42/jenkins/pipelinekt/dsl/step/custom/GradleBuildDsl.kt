package com.code42.jenkins.pipelinekt.dsl.step.custom

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.credentials.UsernamePassword
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
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withCredentials
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withEnv

sealed class ShellContext {
    object Bat : ShellContext()
    object Sh : ShellContext()
    data class Inferred(val booleanStatement: BooleanStatement = BooleanStatement.StringOperator.Contains("PATH".environmentVar(), ("C:".strSingle()))) : ShellContext()
}

data class GradleBuildDsl(
    val shellContext: ShellContext = ShellContext.Sh,
    val gradleCredentials: UsernamePassword? = null,
    val gradleUserProperty: String = "gradle.wrapperUser",
    val gradlePasswordProperty: String = "gradle.wrapperPassword"
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
                mapOf("GRADLE_USER_HOME" to "${"WORKSPACE".environmentVar()}/.gradle-home-tmp",
                "JENKINS_NODE_COOKIE" to "dontKillMe")
            ) { artifactoryAuthenticated {
                sh(("./gradlew --stacktrace --build-cache " +
                        (gradleCredentials?.let { "-D$gradleUserProperty=\\\"\\\${${it.usernameVariable.value}}\\\" -D$gradlePasswordProperty=\\\"\\\${${it.passwordVariable.value}}\\\" " } ?: "") +
                        "$additionalBuildArgs $command").strDouble())
            } }

    fun DslContext<Step>.gradleCommandBat(command: String, additionalBuildArgs: Var.Literal.Str) =
            withEnv(
                    mapOf("GRADLE_USER_HOME" to "${"WORKSPACE".environmentVar()}/.gradle-home-tmp",
                    "JENKINS_NODE_COOKIE" to "dontKillMe")
            ) { artifactoryAuthenticated {
                bat(("call gradlew.bat --stacktrace --build-cache " +
                        (gradleCredentials?.let { "-D$gradleUserProperty=%${it.usernameVariable.value}% -D$gradlePasswordProperty=%${it.passwordVariable.value}% " } ?: "") +
                        "$additionalBuildArgs $command").strDouble())
            } }

    fun DslContext<Step>.gradleCommandMultiPlatform(command: String, additionalBuildArgs: Var.Literal.Str, booleanStatement: BooleanStatement = "PATH".environmentVar().containsSubstring("C:".strSingle())) =
            condition({ booleanStatement },
                        { gradleCommandBat(command, additionalBuildArgs) },
                        { gradleCommandSh(command, additionalBuildArgs) })

    private fun DslContext<Step>.artifactoryAuthenticated(steps: DslContext<Step>.() -> Unit) =
        gradleCredentials?.let { withCredentials(it, steps) } ?: steps()
}
