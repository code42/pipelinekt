package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.step.declarative.echo

fun PipelineDsl.helloWorldPipeline() =
    pipeline {
        agent {
            label("linux")
        }
        stages {
            stage("Build") {
                steps {
                    echo("Hello, World!")
                }
            }
        }
    }
