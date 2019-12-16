package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.Bat
import com.code42.jenkins.pipelinekt.internal.step.declarative.Sh
import com.code42.jenkins.pipelinekt.internal.step.declarative.WithEnv
import com.code42.jenkins.pipelinekt.internal.step.scripted.Literal
import com.code42.jenkins.pipelinekt.internal.step.scripted.ReadProperties
import com.code42.jenkins.pipelinekt.internal.step.scripted.VariableAssignment
import kotlin.test.assertEquals
import org.junit.Test

class VariableAssignmentTest : GroovyScriptTest() {

    @Test fun variableAssignment() {
        val workspaceVar = Var.Variable("workspace")
        val buildPropsVar = Var.Variable("buildProperties")
        val sanitizedReleaseVar = Var.Variable("sanitizedRelease")

        val readProperties = ReadProperties("$workspaceVar/build_vars".strDouble())

        val steps =
                VariableAssignment(variable = buildPropsVar, steps = readProperties)
                        .andThen(
                                VariableAssignment(
                                        variable = sanitizedReleaseVar,
                                        steps =
                                        Literal(buildPropsVar.accessMember("SANITIZED_RELEASE").toGroovy())
                                                .andThen(Literal(".replaceAll(\"\\\\s\", \"_\")"))))
                        .andThen(WithEnv.ofConstToVar(
                                envs = mapOf("SANITIZED_RELEASE" to sanitizedReleaseVar),
                                steps = Sh("echo \${SANITIZED_RELEASE}".strSingle())
                                        .andThen(Bat("echo \${SANITIZED_RELEASE}".strSingle()))))

        val expected = "script {\n" +
                "\tbuildProperties =\n" +
                "\t\treadProperties file: \"\${workspace}/build_vars\"\n" +
                "\tsanitizedRelease =\n" +
                "\t\tbuildProperties.SANITIZED_RELEASE\n" +
                "\t\t.replaceAll(\"\\\\s\", \"_\")\n" +
                "\twithEnv([\n" +
                "\t\t\"SANITIZED_RELEASE=\${sanitizedRelease}\"\n" +
                "\t]) {\n" +
                "\t\tsh (script: 'echo \${SANITIZED_RELEASE}', returnStdout: false)\n" +
                "\t\tbat (script: 'echo \${SANITIZED_RELEASE}', returnStdout: false)\n" +
                "\t}\n" +
                "}\n"

        steps.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
