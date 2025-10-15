package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.core.Pipeline
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.PipelineDsl
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.agent.label
import com.code42.jenkins.pipelinekt.dsl.pipeline
import com.code42.jenkins.pipelinekt.dsl.stage
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.declarative.bat
import com.code42.jenkins.pipelinekt.dsl.step.declarative.echo
import com.code42.jenkins.pipelinekt.dsl.step.scripted.ws
import com.code42.jenkins.pipelinekt.internal.agent.Agent

/**
 * Common imports for examples
 * This file provides the necessary imports for the example files to work correctly.
 */
class ExamplesImports