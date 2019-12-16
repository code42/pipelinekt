package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

object SkipDefaultCheckout : StageOption {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("skipDefaultCheckout()")
    }
}
