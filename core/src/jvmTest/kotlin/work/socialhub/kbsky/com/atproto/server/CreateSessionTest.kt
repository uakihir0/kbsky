package work.socialhub.kbsky.com.atproto.server

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionRequest
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

        println(response.data.email)
        println(response.data.emailConfirmed)
        println(response.data.didDoc?.asDIDDetails?.id)
        println(response.data.didDoc?.asDIDDetails?.service?.get(0)?.serviceEndpoint)


        // Save the accessJwt for testing other APIs
        jwt.accessJwt = checkNotNull(response.data.accessJwt)
        jwt.refreshJwt = checkNotNull(response.data.refreshJwt)
        saveJwt()
    }
}
