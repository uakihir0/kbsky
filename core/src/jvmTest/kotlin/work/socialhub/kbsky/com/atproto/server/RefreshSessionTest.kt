package work.socialhub.kbsky.com.atproto.server

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class RefreshSessionTest : AbstractTest() {

    @Test
    fun testRefreshSession() {

        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .server()
            .refreshSession(AuthRequest(auth()))

        println(response.data.accessJwt)
        println(response.data.refreshJwt)
        println(response.data.handle)
        println(response.data.did)

        jwt.accessJwt = response.data.accessJwt
        jwt.refreshJwt = response.data.refreshJwt
        saveJwt()
    }
}