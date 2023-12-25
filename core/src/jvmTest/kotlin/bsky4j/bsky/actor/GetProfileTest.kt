package kbsky.bsky.actor

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.actor.ActorGetProfileRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetProfileTest : AbstractTest() {

    @Test
    fun testGetProfile() {
        val actor = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .actor()
            .getProfile(
                ActorGetProfileRequest(accessJwt).also {
                    it.actor = "uakihir0.com"
                }
            )

        print(actor.data)
    }
}
