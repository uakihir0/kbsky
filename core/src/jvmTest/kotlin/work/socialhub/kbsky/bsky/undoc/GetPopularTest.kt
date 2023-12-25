package work.socialhub.kbsky.bsky.undoc

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocGetPopularRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetPopularTest : AbstractTest() {

    @Test
    fun testGetPopular() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .undoc()
            .getPopular(
                UndocGetPopularRequest(accessJwt)
            )

        checkNotNull(feeds.data.feed).forEach {
            print(it.post)
        }
    }
}
