package work.socialhub.kbsky.com.atproto.server

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import kotlin.test.Test

class GetSessionTest : AbstractTest() {

    @Test
    fun testGetSession() = runTest {
        val response = client()
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