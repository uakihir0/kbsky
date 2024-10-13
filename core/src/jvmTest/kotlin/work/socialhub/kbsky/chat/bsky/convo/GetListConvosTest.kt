package work.socialhub.kbsky.chat.bsky.convo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetListConvosRequest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import kotlin.test.Test

class GetListConvosTest : AbstractTest() {

    @Test
    fun testGetListConvos() {
        val convos = BlueskyFactory
            .instance().also {
                it.server()
                    .getSession(
                        AuthRequest(auth())
                    )
            }
            .convo()
            .getListConvos(
                ConvoGetListConvosRequest(auth())
            )

        convos.data.convos.forEach {
            dump(it)
        }
    }
}