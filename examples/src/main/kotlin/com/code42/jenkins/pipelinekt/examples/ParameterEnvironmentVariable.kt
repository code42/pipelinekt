package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.parameter.string
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withEnvVars
import com.code42.jenkins.pipelinekt.core.vars.ext.parameter
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle

val myParam = "myParam".parameter()

fun PipelineDsl.parameterAsEnvironmentVariable() =
    pipeline {
            parameters {
                string(
                        name = myParam.name,
                        defaultValue = "default",
                        description = "A parameter that is passed into a bash script")
            }
            stages {
                stage("Build") {
                    steps {
                        withEnvVars(mapOf("MY_ENV" to myParam)) {
                            sh("./ci/scripts/myScript.sh \${MY_ENV}".strSingle())
                        }
                    }
                }
            }
    }
