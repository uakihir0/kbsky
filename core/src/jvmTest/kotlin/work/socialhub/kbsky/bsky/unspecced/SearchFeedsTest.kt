package work.socialhub.kbsky.bsky.unspecced

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedSearchFeedsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchFeedsTest : AbstractTest() {

    @Test
    fun testSearchFeeds() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .unspecced()
            .searchFeeds(
                UnspeccedSearchFeedsRequest().also {
                    it.q = "SocialHub"
                }
            )

        feeds.data.forEach {
            println(checkNotNull(it.post).text)
        }
    }
}
