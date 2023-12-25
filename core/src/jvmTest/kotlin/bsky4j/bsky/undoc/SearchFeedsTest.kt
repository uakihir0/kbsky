package kbsky.bsky.undoc

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocSearchFeedsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchFeedsTest : AbstractTest() {

    @Test
    fun testSearchFeeds() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .undoc()
            .searchFeeds(
                UndocSearchFeedsRequest().also {
                    it.q = "SocialHub"
                }
            )

        feeds.data.forEach {
            println(checkNotNull(it.post).text)
        }
    }
}
