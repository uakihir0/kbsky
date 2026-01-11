package work.socialhub.kbsky.com.atproto.identity

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleRequest
import kotlin.test.Test

class ResolveHandleTest() : AbstractTest() {

    @Test
    fun testResolveHandle() = runTest {
        val response = client()
            .identity()
            .resolveHandle(
                IdentityResolveHandleRequest().also {
                    it.handle = "uakihir0.com"
                }
            )

        println(response.data.did)
    }
}
