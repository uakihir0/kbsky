package work.socialhub.kbsky.com.atproto.server

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetSessionTest : AbstractTest() {

    @Test
    fun testGetSession() {
        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .server()
            .getSession(
                AuthRequest(auth())
            )

        println(response.data.did)
        println(response.data.handle)
        println(response.data.email)
        println(response.data.emailConfirmed)
        println(response.data.didDoc?.asDIDDetails?.id)
    }
}