package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.ScriptedParallel

/**
 * Executes some steps in parallel
 *
 * Warning, please read the docs before using this.
 *
 * At the time of writing, you cannot run nested parallel blocks
 * https://issues.jenkins-ci.org/browse/JENKINS-54010?page=com.atlassian.jira.plugin.system.issuetabpanels%3Achangehistory-tabpanel
 *
 * This implements the workaround documented by CloudBees here: https://support.cloudbees.com/hc/en-us/articles/115000088431-Create-a-Matrix-like-flow-with-Pipeline
 */
fun DslContext<Step>.inParallel(scriptedStages: Map<String, DslContext<Step>.() -> Unit>) {
    val steps = scriptedStages
            .map { (k, v) ->
                k.strDouble() to DslContext.into(v).toStep()
            }
            .toMap()

    add(ScriptedParallel(steps))
}
