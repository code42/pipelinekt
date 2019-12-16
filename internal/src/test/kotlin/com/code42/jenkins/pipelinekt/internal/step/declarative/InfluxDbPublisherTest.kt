package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.parameter
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class InfluxDbPublisherTest : GroovyScriptTest() {
    @Test
    fun serializeTheInfluxDbPublisher() {
        val target = "myteams influx"

        val expected = """
            step([
            ${indentStr}${'$'}class: 'InfluxDbPublisher',
            ${indentStr}target: '$target',
            ${indentStr}selectedTarget: '$target',
            ${indentStr}customPrefix: null,
            ${indentStr}customData: [:],
            ${indentStr}customDataTags: [:],
            ${indentStr}customDataMap: [:],
            ${indentStr}customDataMapTags: [:]
            ])
        
        """.trimIndent()
        InfluxDbPublisher(target.strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun serializeTheInfluxDbPublisher_withCustomData() {
        val target = "myteams influx"
        val customData = mapOf("myField" to "env_var".environmentVar(), "myParam" to "parameter".parameter(), "constant" to "str".strSingle())
        val expected = """
            step([
            ${indentStr}${'$'}class: 'InfluxDbPublisher',
            ${indentStr}target: '$target',
            ${indentStr}selectedTarget: '$target',
            ${indentStr}customPrefix: null,
            ${indentStr}customData: [
            ${indentStr.repeat(2)}myField: env.env_var,
            ${indentStr.repeat(2)}myParam: params.parameter,
            ${indentStr.repeat(2)}constant: 'str' ],
            ${indentStr}customDataTags: [:],
            ${indentStr}customDataMap: [:],
            ${indentStr}customDataMapTags: [:]
            ])
        
        """.trimIndent()
        InfluxDbPublisher(target = target.strSingle(),
                customData = customData).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun serializeTheInfluxDbPublisher_withCustomDataAndTags() {
        val target = "myteams influx"
        val customData = mapOf("myField" to "env_var".environmentVar(), "myParam" to "parameter".parameter(), "constant" to "str".strSingle())

        val customTags = mapOf("myTag" to "customTag".strSingle(), "interpolated" to "${"my_env".environmentVar()}".strDouble())

        val expected = """
            step([
            ${indentStr}${'$'}class: 'InfluxDbPublisher',
            ${indentStr}target: '$target',
            ${indentStr}selectedTarget: '$target',
            ${indentStr}customPrefix: null,
            ${indentStr}customData: [
            ${indentStr.repeat(2)}myField: env.env_var,
            ${indentStr.repeat(2)}myParam: params.parameter,
            ${indentStr.repeat(2)}constant: 'str' ],
            ${indentStr}customDataTags: [
            ${indentStr.repeat(2)}myTag: 'customTag',
            ${indentStr.repeat(2)}interpolated: "${'$'}{env.my_env}" ],
            ${indentStr}customDataMap: [:],
            ${indentStr}customDataMapTags: [:]
            ])
        
        """.trimIndent()
        InfluxDbPublisher(target = target.strSingle(),
                customData = customData,
                customDataTags = customTags).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun serializeTheInfluxDbPublisher_withCustomDataMapAndMapTags() {
        val target = "myteams influx"
        val customData = mapOf("myField" to "env_var".environmentVar(), "myParam" to "parameter".parameter(), "constant" to "str".strSingle())

        val customTags = mapOf("myTag" to "customTag".strSingle(), "interpolated" to "${"my_env".environmentVar()}".strDouble())

        val customDataMap = mapOf(
                "m1" to mapOf("f1" to "v1".strSingle()),
                "m2" to mapOf("f2" to "f2".strSingle(), "env2" to "env1".environmentVar())
        )

        val customDataMapTags = mapOf(
                "m1" to mapOf("t1" to "v1".strSingle()),
                "m2" to mapOf("t2" to "f2".strSingle(), "t3" to "${"env1".environmentVar()}".strDouble()))
        val expected = """
            step([
            ${indentStr}${'$'}class: 'InfluxDbPublisher',
            ${indentStr}target: '$target',
            ${indentStr}selectedTarget: '$target',
            ${indentStr}customPrefix: null,
            ${indentStr}customData: [
            ${indentStr.repeat(2)}myField: env.env_var,
            ${indentStr.repeat(2)}myParam: params.parameter,
            ${indentStr.repeat(2)}constant: 'str' ],
            ${indentStr}customDataTags: [
            ${indentStr.repeat(2)}myTag: 'customTag',
            ${indentStr.repeat(2)}interpolated: "${'$'}{env.my_env}" ],
            ${indentStr}customDataMap: [
            ${indentStr.repeat(2)}m1: [
            ${indentStr.repeat(3)}f1: 'v1' ],
            ${indentStr.repeat(2)}m2: [
            ${indentStr.repeat(3)}f2: 'f2',
            ${indentStr.repeat(3)}env2: env.env1 ] ],
            ${indentStr}customDataMapTags: [
            ${indentStr.repeat(2)}m1: [
            ${indentStr.repeat(3)}t1: 'v1' ],
            ${indentStr.repeat(2)}m2: [
            ${indentStr.repeat(3)}t2: 'f2',
            ${indentStr.repeat(3)}t3: "${'$'}{env.env1}" ] ]
            ])
        
        """.trimIndent()
        InfluxDbPublisher(target = target.strSingle(),
                customData = customData,
                customDataTags = customTags,
                customDataMap = customDataMap,
                customDataMapTags = customDataMapTags).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
