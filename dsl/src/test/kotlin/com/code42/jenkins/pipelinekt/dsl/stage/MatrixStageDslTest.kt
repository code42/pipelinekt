package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Pipeline
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.method.PipelineMethodInvocation
import com.code42.jenkins.pipelinekt.core.stage.ExcludeAxis
import com.code42.jenkins.pipelinekt.core.stage.MatrixAxis
import com.code42.jenkins.pipelinekt.core.stage.MatrixBody
import com.code42.jenkins.pipelinekt.core.stage.MatrixExclude
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.parameter
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.`when`.expression
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.environment.envVar
import com.code42.jenkins.pipelinekt.dsl.option.skipDefaultCheckout
import com.code42.jenkins.pipelinekt.dsl.option.timeout
import com.code42.jenkins.pipelinekt.dsl.step.conditional.statement
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.tool.jdk
import com.code42.jenkins.pipelinekt.internal.`when`.Expression
import com.code42.jenkins.pipelinekt.internal.agent.Label
import com.code42.jenkins.pipelinekt.internal.environment.EnvVar
import com.code42.jenkins.pipelinekt.internal.option.SkipDefaultCheckout
import com.code42.jenkins.pipelinekt.internal.option.Timeout
import com.code42.jenkins.pipelinekt.internal.step.declarative.CleanWs
import com.code42.jenkins.pipelinekt.internal.step.declarative.Sh
import com.code42.jenkins.pipelinekt.internal.tools.JDK
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals
import org.junit.Test

class MatrixStageDslTest {
    @Test
    fun matrixStage_objectEquivalence() {
        val pipelineDsl = PipelineDsl(defaultEnvironment = {
            envVar("FOO", "BAR")
        }, defaultBuildOptions = {})

        val pipeline = pipelineDsl.pipeline {
            stages {
                stage("matrix") {
                    `when` { expression { "hello".parameter().statement() } }
                    options { skipDefaultCheckout() }
                    matrix {
                        agent { label("linux") }
                        `when` { expression { "hello_inside".parameter().statement() } }
                        options { timeout(1, TimeUnit.HOURS) }
                        tools { jdk("11") }
                        axes {
                            axis("OS", listOf("mac", "windows", "linux"))
                            axis("BROWSER", listOf("ie", "safari", "chrome", "firefox"))
                        }
                        excludes {
                            exclude {
                                axis("OS", "linux")
                                notAxis("BROWSER", listOf("chrome", "firefox"))
                            }
                        }
                        stages {
                            stage("nested stage") {
                                steps {
                                    sh("./call.sh")
                                }
                            }
                        }
                        post {
                            always {
                                sh("./matrix-always.sh")
                            }
                        }
                    }
                    post {
                        always {
                            sh("./stage-always.sh")
                        }
                    }
                }
            }
        }

        val expected = Pipeline(
            environment = listOf(
                EnvVar("FOO", "BAR")
            ),
            stages = listOf(
                Stage.Matrix(
                    name = "matrix".strDouble(),
                    whenBlock = listOf(Expression("hello".parameter().statement())),
                    options = listOf(SkipDefaultCheckout),
                    matrixBody = MatrixBody(
                        agent = Label("linux".strDouble()),
                        whenBlock = listOf(Expression("hello_inside".parameter().statement())),
                        options = listOf(Timeout(Var.Literal.Int(1), TimeUnit.HOURS)),
                        tools = listOf(JDK("11".strDouble())),
                        axes = listOf(
                            MatrixAxis(
                                "OS".strDouble(),
                                listOf("mac", "windows", "linux").map { it.strDouble() }),
                            MatrixAxis(
                                "BROWSER".strDouble(),
                                listOf("ie", "safari", "chrome", "firefox").map { it.strDouble() })
                        ),
                        excludes = listOf(
                            MatrixExclude(
                                listOf(
                                    ExcludeAxis.Values(
                                        "OS".strDouble(),
                                        listOf("linux".strDouble())
                                    ),
                                    ExcludeAxis.NotValues(
                                        "BROWSER".strDouble(),
                                        listOf("chrome", "firefox").map { it.strDouble() })
                                )
                            )
                        ),
                        stages = listOf(
                            Stage.Steps(
                                name = "nested stage".strDouble(),
                                steps = PipelineMethodInvocation("nested_stage")
                            )
                        ),
                        post = Post(
                            always = Sh("./matrix-always.sh".strDouble())
                        )
                    ),
                    post = Post(
                        always = Sh("./stage-always.sh".strDouble())
                    )
                )
            ),
            methods = listOf(PipelineMethod("nested_stage", Sh("./call.sh".strDouble()))),
            post = Post(
                cleanup = CleanWs(deleteDirs = false, disableDeferredWipeout = false)
            )
        )
        assertEquals(expected, pipeline)
    }
}
