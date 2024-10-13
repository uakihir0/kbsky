package work.socialhub.kbsky.auth

import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class WellKnownTest : AbstractTest() {

    @Test
    fun testWellKnownOAuthProtectedResource() {
        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .wellKnown()
            .oAuthProtectedResource()
        println(response.data.authorizationServers[0])
    }

    @Test
    fun testWell() {
        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .wellKnown()
            .oAuthAuthorizationServer()
        println(response.data.issuer)
    }
}