package work.socialhub.kbsky.chat.bsky.convo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoRequest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import kotlin.test.Test

class GetConvoTest : AbstractTest() {

    @Test
    fun testGetConvo() {
        val convoId = "3kvn6dlqy5v25"

        val convo = BlueskyFactory
            .instance().also {
                it.server()
                    .getSession(
                        AuthRequest(accessJwt)
                    )
            }
            .convo()
            .getConvo(
                ConvoGetConvoRequest(accessJwt).also {
                    it.convoId = convoId
                }
            )

        dump(convo.data.convo)
    }
}