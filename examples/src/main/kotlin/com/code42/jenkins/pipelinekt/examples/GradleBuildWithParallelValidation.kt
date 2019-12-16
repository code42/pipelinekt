package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.step.custom.GradleBuildDsl
import com.code42.jenkins.pipelinekt.dsl.step.declarative.archiveArtifacts

val gradleArgs = "-DmyArg=myArgValue"

val gradle = GradleBuildDsl()
/**
 * Pipeline
 */
fun PipelineDsl.gradleBuildPipeline() =
        gradle.run {
            pipeline {
                stages {
                    stage("Build") {
                        steps {
                            gradleCommand("build $gradleArgs")
                        }
                    }
                    stage("Validate") {
                        parallel {
                            listOf("api", "ext", "shared", "mod1").forEach { subProject ->
                                stage("$subProject Test") {
                                    agent(defaultAgent)
                                    steps {
                                        gradleCommand(":$subProject:systemTest $gradleArgs")
                                    }
                                    post {
                                        always {
                                            archiveArtifacts("$subProject/build/test-reports/", true)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    stage("Publish") {
                        agent(defaultAgent)
                        steps {
                            gradleCommand("publish $gradleArgs")
                        }
                    }
                }
            }
        }
