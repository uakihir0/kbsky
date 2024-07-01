package work.socialhub.kbsky.chat.bsky.convo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoRequest
import work.socialhub.kbsky.domain.Service.OYSTER_US_EAST
import kotlin.test.Test

class GetConvoTest : AbstractTest() {

    @Test
    fun testGetConvo() {
        val convoId = "3kvn6dlqy5v25"

        val convo = BlueskyFactory
            .instance(OYSTER_US_EAST.uri)
            .convo()
            .getConvo(
                ConvoGetConvoRequest(accessJwt).also {
                    it.convoId = convoId
                }
            )

        dump(convo.data.convo)
    }
}