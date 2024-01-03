package work.socialhub.kbsky.atproto.server

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class GetSessionTest : AbstractTest() {

    @Test
    fun testGetSession() {
        val response = ATProtocolFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .server()
            .getSession(
                AuthRequest(accessJwt)
            )

        println(response.data.did)
        println(response.data.handle)
        println(response.data.email)
        println(response.data.emailConfirmed)
        println(response.data.didDoc?.DIDDetails()?.id)
    }
}