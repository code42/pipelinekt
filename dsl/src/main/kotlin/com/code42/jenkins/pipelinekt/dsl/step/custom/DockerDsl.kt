package com.code42.jenkins.pipelinekt.dsl.step.custom

import com.code42.jenkins.pipelinekt.core.agent.DockerAgent
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.step.scripted.DockerVar
import com.code42.jenkins.pipelinekt.dsl.step.scripted.dockerBuild
import com.code42.jenkins.pipelinekt.dsl.step.scripted.dockerImage
import com.code42.jenkins.pipelinekt.dsl.step.scripted.withDockerRegistry
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

        val sideCarArgs = sideCars
                .map { "--link ${it.containerVariable.accessMember("id")}:${it.containerLinkName}" }
                .joinToString(" ")
        val mainContainerRunArgs = ("${dockerAgent.args ?: "".strSingle()} " + sideCarArgs)
        val mainContainerId = UUID.randomUUID().toString().replace("[^A-Za-z0-9 ]".toRegex(), "")

        applyRegistrySettings(dockerAgent) {
            withSideCars(sideCars) {
                beforeContainer()
                buildOrPull(dockerAgent, mainContainerId)
                        .inside(mainContainerRunArgs, steps)
            }
        }
    }

    private fun DslContext<Step>.applyRegistrySettings(agent: DockerAgent, steps: DslContext<Step>.() -> Unit) =
            agent.registryUrl
                    ?.let { withDockerRegistry(it, agent.registryCredentialsId, steps) }
                    ?: steps()

    private fun DslContext<Step>.sideCar(sideCar: SideCar, steps: DslContext<Step>.() -> Unit) {
        when (sideCar) {
            is SideCar.Image ->
                dockerImage(sideCar.image)
                        .withRun(args = sideCar.runArgs,
                                command = sideCar.runCommand,
                                containerVariable = sideCar.containerVariable,
                                steps = steps)
        }
    }

    private fun DslContext<Step>.withSideCars(sideCars: List<SideCar>, steps: DslContext<Step>.() -> Unit) {
        val fn = sideCars.fold(steps, { buildSteps, sideCar ->
            val it: DslContext<Step>.() -> Unit = { sideCar(sideCar, buildSteps) }
            it
        })
        this.fn()
    }

    private fun DslContext<Step>.buildOrPull(agent: DockerAgent, imageName: String): DockerVar =
            when (agent) {
                is DockerAgent.File -> {
                    val buildArgs = "--file ${agent.filename} " +
                            "$defaultDockerBuildArgs " +
                            "${agent.additionalBuildArgs ?: ""} " +
                            "${agent.dir ?: "."}"
                    dockerBuild(imageName, buildArgs)
                }
                is DockerAgent.Image -> dockerImage(agent.image)
            }
}
