package work.socialhub.kbsky.com.atproto.identity

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ATProtoNativeTest {

    @Test
    fun testResolveHandle() = runTest {
        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .identity()
            .resolveHandle(
                IdentityResolveHandleRequest().also {
                    it.handle = "uakihir0.com"
                }
            )

        println(response.data.did)
    }
}
