package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.step.declarative.echo
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar

val pipelineDsl = PipelineDsl(
        defaultAgent = {
            label("linux")
        },
        beforeLocalStage = {
            echo("Hello, I am a stage and I am running on '${"NODE_NAME".environmentVar()}', which I have inherited from the parent context")
        },
        beforeRemoteStage = {
            echo("Hello, I am a stage and I am running on '${"NODE_NAME".environmentVar()}")
        }
)

val myConfiguredPipeline = pipelineDsl.pipeline {
    // inherits default agent
    stages {
        stage("Build") {
            steps {
                sh("./build.sh")
            }
        }
        stage("Validation") {
            parallel {
                stage("Unit Test") {
                    steps {
                        sh("./unitTest.sh")
                    }
                }
                stage("Integration Test") {
                    agent(defaultAgent)
                    steps {
                        sh("./integrationTest.sh")
                    }
                }

                stage("Acceptance") {
                    agent {
                        label("acceptance && linux")
                    }

                    steps {
                        sh("./acceptanceTest.sh")
                    }
                }
            }
        }
    }
}
