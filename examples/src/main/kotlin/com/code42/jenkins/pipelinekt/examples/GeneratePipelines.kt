package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.core.generatePipeline
fun main() {
    val context = PipelineDsl()
    generatePipeline(context.helloWorldPipeline(), "examples/src/generated/ci/hello.Jenkinsfile")
    generatePipeline(context.gradleBuildPipeline(), "examples/src/generated/ci/gradleBuild.Jenkinsfile")
    generatePipeline(context.windowsPipeline(), "examples/src/generated/ci/windows.jenkinsfile")
    generatePipeline(context.staticEnvVarPipeline(), "examples/src/generated/ci/env.Jenkinsfile")
    generatePipeline(context.parameterAsEnvironmentVariable(), "examples/src/generated/ci/envVar.Jenkinsfile")
    generatePipeline(context.conditionalPipeline(), "examples/src/generated/ci/conditional.Jenkinsfile")
    generatePipeline(context.dockerPipeline(), "examples/src/generated/ci/docker.Jenkinsfile")

}
