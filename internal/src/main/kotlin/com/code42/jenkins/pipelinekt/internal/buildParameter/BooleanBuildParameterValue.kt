package com.code42.jenkins.pipelinekt.internal.buildParameter

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.buildParameter.BuildParameterValue
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.parameters.BooleanParam

data class BooleanBuildParameterValue(val name: Var.Literal.Str, val value: Var) : BuildParameterValue {
    override fun toParameterDefintion(): Parameter =
            BooleanParam(defaultValue = false, description = "".strSingle(), name = name)

    override fun toGroovy(): String {
        return "[\$class: 'hudson.model.BooleanParameterValue', name: ${name.toGroovy()}, value: ${value.toGroovy()}]"
    }
}
