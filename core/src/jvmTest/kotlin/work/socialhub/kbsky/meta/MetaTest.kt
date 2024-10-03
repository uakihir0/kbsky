package work.socialhub.kbsky.meta

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.domain.Service.OYSTER_US_EAST
import kotlin.test.Test

class MetaTest : AbstractTest() {

    @Test
    fun testWellKnownOAuthProtectedResource() {
        val response = BlueskyFactory
            .instance(OYSTER_US_EAST.uri)
            .meta()
            .wellKnownOAuthProtectedResource()
        println(response.data.authorizationServers[0])
    }

    @Test
    fun testWell() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .meta()
            .wellKnownOAuthAuthorizationServer()
        println(response.data.issuer)
    }
}
