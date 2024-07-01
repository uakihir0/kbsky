package work.socialhub.kbsky.chat.bsky.convo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.chat.bsky.convo.ConvoGetListConvosRequest
import kotlin.test.Test

class GetListConvosTest : AbstractTest() {

    @Test
    fun testGetListConvos() {
        val convos = BlueskyFactory
            .instance(endpoint())
            .convo()
            .getListConvos(
                ConvoGetListConvosRequest(accessJwt)
            )

        convos.data.convos.forEach {
            dump(it)
        }
    }
}