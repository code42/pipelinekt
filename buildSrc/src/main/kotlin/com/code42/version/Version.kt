package com.code42.version

import java.io.File

object Version {
    fun incrementVersion() {
        val versionFile = File("version.txt")
        val version = versionFile.readText()
                .split(".")
                .let {versionString ->
                    val versions = versionString.mapNotNull { it.toIntOrNull() }
                    if(versions.size != 3) {
                        throw IllegalArgumentException("version.txt should contain a version property with 3 parts, but contained $versionString")
                    }
                    val major = versions[0]
                    val minor = versions[1]
                    val patch = versions[2] + 1

                    "$major.$minor.${patch}"
                }

        versionFile.writeText("$version")
    }

    fun getVersion(): String {
        return File("version.txt").readText()
    }
}