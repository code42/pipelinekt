package com.code42.jenkins.pipelinekt.core

import junit.framework.Assert.assertEquals
import org.junit.Test

class LibraryTest : GroovyScriptTest() {
    @Test
    fun shouldWriteALibraryToGroovy() {
        val library = PipelineLibrary("lib-name", "version-tag", "a-suffix")

        library.toGroovy(writer)
        assertEquals("@Library(\"lib-name@version-tag\") a-suffix\n", out.toString())
    }
}
