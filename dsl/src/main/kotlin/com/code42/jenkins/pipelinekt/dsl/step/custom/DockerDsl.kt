package com.code42.jenkins.pipelinekt.dsl.step.custom

import com.code42.jenkins.pipelinekt.core.agent.DockerAgent
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.Docker
import java.util.UUID

sealed class SideCar {
    abstract val containerVariable: Var.Variable
    abstract val containerLinkName: String
    abstract val runArgs: Var.Literal.Str
    abstract val runCommand: Var.Literal.Str?

    data class Image(
            // Name of the variable in the groovy withRun closure
        override val containerVariable: Var.Variable,
            // Name of the container for host linking (i.e. the DNS by wich other containers will call this
            // container on the network)
        override val containerLinkName: String,
            // image to use, inherites registry from parent if defined
        val image: Var.Literal.Str,
            // include any expose posrts here
        override val runArgs: Var.Literal.Str,
            // custom container command
        override val runCommand: Var.Literal.Str? = null
    ) : SideCar()
}

data class DockerDsl(
    val defaultDockerBuildArgs: String,
    val beforeContainer: DslContext<Step>.() -> Unit
) {
    /**
     * Run some steps inside of a container, inject "beforeContainer" and use "defaultDockerBuildArgs" if using a
     * docker container agent.
     */
    fun DslContext<Step>.insideContainer(
        dockerAgent: SingletonDslContext<DockerAgent>.() -> Unit,
        sideCars: List<SideCar> = emptyList(),
        steps: DslContext<Step>.() -> Unit
    ) {
        val dockerAgent = SingletonDslContext.into(dockerAgent)
                ?: throw IllegalStateException("Must define a docker agent")
        insideContainer(dockerAgent, sideCars, DslContext.into(steps).toStep())
    }

    fun DslContext<Step>.insideContainer(
        agent: DockerAgent,
        sideCars: List<SideCar> = emptyList(),
        steps: Step
    ) {
        val sideCarArgs = sideCars
                .map { "--link ${it.containerVariable.accessMember("id")}:${it.containerLinkName}" }
                .joinToString(" ")
        val mainContainerRunArgs = ("${agent.args ?: "".strSingle()} " + sideCarArgs).strDouble()
        val mainContainerId = UUID.randomUUID().toString().replace("[^A-Za-z0-9 ]".toRegex(), "").strSingle()

        beforeContainer()
        add(agent.applyRegistrySettings(
                withSideCars(
                        sideCars,
                        agent.buildOrPull(mainContainerId).inside(mainContainerRunArgs, steps))))
    }

    private fun DockerAgent.applyRegistrySettings(steps: Step): Step =
            this.registryUrl
                    ?.let { Docker.WithRegistry(it, this.registryCredentialsId, steps) }
                    ?: steps

    private fun sideCar(sideCar: SideCar, steps: Step): Step =
            when (sideCar) {
                is SideCar.Image -> com.code42.jenkins.pipelinekt.internal.step.scripted.Docker.Image(sideCar.image)
                        .withRun(args = sideCar.runArgs,
                                steps = steps,
                                command = sideCar.runCommand,
                                containerVariable = sideCar.containerVariable)
            }

    private fun withSideCars(sideCars: List<SideCar>, steps: Step): Step =
            sideCars.fold(steps, { buildSteps, sideCar ->
                sideCar(sideCar, buildSteps)
            })

    private fun DockerAgent.buildOrPull(imageName: Var.Literal.Str): Docker.ImageOps =
            when (this) {
                is DockerAgent.File -> {
                    val buildArgs = "--file ${this.filename} " +
                            "$defaultDockerBuildArgs " +
                            "${this.additionalBuildArgs ?: ""} " +
                            "${this.dir ?: "."}"
                    Docker.Build(imageName, buildArgs.strDouble())
                }
                is DockerAgent.Image -> Docker.Image(this.image)
            }
}
