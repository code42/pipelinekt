package com.code42.jenkins.pipelinekt.core.notifications

import kotlin.test.assertEquals
import org.junit.Test

class RecipientProviderTest {
    @Test fun hasCulpritsAndRequester() {
        val expected = listOf<String>("[\$class: 'CulpritsRecipientProvider']", "[\$class: 'RequesterRecipientProvider']").joinToString(",")
        val actual = listOf<String>(RecipientProvider.Culprits.toGroovy(), RecipientProvider.Requester.toGroovy()).joinToString(",")

        assertEquals(expected, actual)
    }
}
