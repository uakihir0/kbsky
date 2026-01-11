package work.socialhub.kbsky.app.bsky.labeler

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.labeler.LabelerGetServicesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetServicesTest : AbstractTest() {

    @Test
    fun testGetServices() = runTest {
        val response = client()
            .labeler()
            .getServices(
                LabelerGetServicesRequest(auth()).also {
                    it.dids = listOf("did:plc:ar7c4by46qjdydhdevvrndac", "did:plc:fcikraffwejtuqffifeykcml")
                    it.detailed = true
                }
            )

        response.data.views
            .forEach {
                println(it.asLabelerViewDetailed?.creator?.displayName)
                println("  likes: " + it.asLabelerViewDetailed?.likeCount)
                println("  labelValues: " + it.asLabelerViewDetailed?.policies?.labelValues)
            }
    }
}
