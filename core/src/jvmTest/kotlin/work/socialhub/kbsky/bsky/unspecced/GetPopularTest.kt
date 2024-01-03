package work.socialhub.kbsky.bsky.unspecced

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetPopularTest : AbstractTest() {

    @Test
    fun testGetPopular() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .unspecced()
            .getPopular(
                UnspeccedGetPopularRequest(accessJwt)
            )

        feeds.data.feed.forEach {
            print(it.post)
        }
    }
}
