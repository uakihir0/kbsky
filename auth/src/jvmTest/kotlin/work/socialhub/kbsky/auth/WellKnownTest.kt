package work.socialhub.kbsky.auth

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.domain.Service.OYSTER_US_EAST
import kotlin.test.Test

class WellKnownTest : AbstractTest() {

    @Test
    fun testWellKnownOAuthProtectedResource() = runTest {
        val response = AuthFactory
            .instance(OYSTER_US_EAST.uri)
            .wellKnown()
            .oAuthProtectedResource()
        println(response.data.authorizationServers[0])
    }

    @Test
    fun testWellKnownOAuthAuthorizationServer() = runTest {
        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .wellKnown()
            .oAuthAuthorizationServer()
        println(response.data.issuer)
    }
}