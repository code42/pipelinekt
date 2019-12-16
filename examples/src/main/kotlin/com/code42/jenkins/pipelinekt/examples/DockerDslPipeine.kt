package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.agent.dockerFile
import com.code42.jenkins.pipelinekt.dsl.step.custom.DockerDsl
import com.code42.jenkins.pipelinekt.dsl.step.custom.SideCar
import com.code42.jenkins.pipelinekt.dsl.step.declarative.echo
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.scripted.def

val uid = "uid".groovyVariable()
val dockerDsl = DockerDsl(
        defaultDockerBuildArgs = "-u $uid",
        beforeContainer = { def(uid.name) { sh("id -u", true) } })

val sideCars = listOf(SideCar.Image(
        containerVariable = "postgres".groovyVariable(),
        containerLinkName = "db",
        image = "postgres:11".strDouble(),
        runArgs = "--env DB=app --expose 5432".strDouble()),
        SideCar.Image(
                containerVariable = "rabbitmq".groovyVariable(),
                containerLinkName = "rabbit",
                image = "rabbitmq:11".strDouble(),
                runArgs = "--expose 5672".strDouble()))

fun PipelineDsl.dockerPipeline() = pipeline {
    stages {
        stage("build in container") {
            steps {
                dockerDsl.run {
                    insideContainer(
                            dockerAgent = { dockerFile(
                                    filename = "build.Dockerfile",
                                    additionalBuildArgs = "--arg1 y",
                                    registryUrl = "my.custom.registry",
                                    registryCredentialsId = "registry-creds-id")
                            },
                            sideCars = sideCars
                    ) {
                        echo("Inside a container!")
                        sh("psql -h db -p 5432 app")
                    }
                }
            }
        }
    }
}