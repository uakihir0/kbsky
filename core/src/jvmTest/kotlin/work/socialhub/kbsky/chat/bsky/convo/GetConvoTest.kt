package work.socialhub.kbsky.chat.bsky.convo

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetConvoRequest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import kotlin.test.Test

class GetConvoTest : AbstractTest() {

    @Test
    fun testGetConvo() = runTest {
        val convoId = "3kvn6dlqy5v25"

        val convo = client()
            .also {
                it.server()
                    .getSession(
                        AuthRequest(auth())
                    )
            }
            .convo()
            .getConvo(
                ConvoGetConvoRequest(auth()).also {
                    it.convoId = convoId
                }
            )

        dump(convo.data.convo)
    }
}