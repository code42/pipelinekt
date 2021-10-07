package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.core.vars.ext.parameter
import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.`when`.expression
import com.code42.jenkins.pipelinekt.dsl.step.conditional.`==`
import com.code42.jenkins.pipelinekt.dsl.step.conditional.`if`
import com.code42.jenkins.pipelinekt.dsl.step.conditional.`||`
import com.code42.jenkins.pipelinekt.dsl.step.conditional.statement
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.scripted.def

fun PipelineDsl.conditionalPipeline() = pipeline {
    stages {
        stage("Build") {
            `when` { expression { "DO_BUILD".parameter().statement() }}
            steps {
                sh("./build.sh")
                val isRelease = def { sh(script = "./isRelease.sh", returnStdout = true) }
                `if`((isRelease `==` "true") `||` "DO_RELEASE".parameter(),
                        `then` = {
                            sh("./publishRelease.sh")
                        },
                        `else` = {
                            sh("./publishSnapshot.sh")
                        })
            }
        }
    }
}