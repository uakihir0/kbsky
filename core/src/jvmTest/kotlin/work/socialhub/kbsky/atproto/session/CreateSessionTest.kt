package work.socialhub.kbsky.atproto.session

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class CreateSessionTest : AbstractTest() {

    @Test
    fun testCreateSession() {
        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .server()
            .createSession(
                ServerCreateSessionRequest().also {
                    it.identifier = handle
                    it.password = password
                }
            )

        println(response.data.accessJwt)
        println(response.data.refreshJwt)
        println(response.data.handle)
        println(response.data.did)

        // Save the accessJwt for testing other APIs
        accessJwt = checkNotNull(response.data.accessJwt)
        saveAccessJwt()
    }
}
