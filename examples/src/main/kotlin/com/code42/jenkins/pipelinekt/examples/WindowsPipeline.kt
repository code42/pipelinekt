package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.step.declarative.bat

fun PipelineDsl.windowsPipeline() = pipeline(pipelineBlock = {
    agent { label("windows") }
    stage("Build") {
        steps {
            bat("echo 'Hello, World'")
        }
    }
})
