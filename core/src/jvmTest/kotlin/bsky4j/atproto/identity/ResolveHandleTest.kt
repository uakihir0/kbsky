package kbsky.atproto.identity

import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ResolveHandleTest {

    @Test
    fun testResolveHandle() {
        val response = BlueskyFactory
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
