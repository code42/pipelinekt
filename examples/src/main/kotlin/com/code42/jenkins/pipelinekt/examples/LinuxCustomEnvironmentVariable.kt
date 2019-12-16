package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withEnv
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle

fun PipelineDsl.staticEnvVarPipeline() =
    pipeline {
        stages {
            stage("Build") {
                steps {
                    withEnv(mapOf("MY_ENV" to "my_static_value")) {
                        // assign a static environment variable
                        sh("./ci/scripts/myScript.sh \${MY_ENV}".strSingle())
                    }
                }
            }
        }
    }
