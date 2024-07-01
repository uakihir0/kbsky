package work.socialhub.kbsky.com.atproto.server

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class RefreshSessionTest : AbstractTest() {

    @Test
    fun testRefreshSession() {
        val client = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)

        // Get RefreshJwt
        refreshJwt = client
            .server()
            .createSession(
                ServerCreateSessionRequest().also {
                    it.identifier = handle
                    it.password = password
                }
            )
            .data
            .refreshJwt

        val response = client
            .server()
            .refreshSession(
                AuthRequest(refreshJwt)
            )

        println(response.data.accessJwt)
        println(response.data.refreshJwt)
        println(response.data.handle)
        println(response.data.did)
    }
}