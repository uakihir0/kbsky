package work.socialhub.kbsky.util

import work.socialhub.kbsky.ATProtocolException
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ErrorTest : AbstractTest() {

    @Test
    fun testError() {

        try {
            BlueskyFactory
                .instance(BSKY_SOCIAL.uri)
                .feed()
                .getActorFeeds(
                    FeedGetActorFeedsRequest("INVALID")
                )

        } catch (e: ATProtocolException) {
            println(e.response?.message)
            println(e.response?.error)
        }
    }
}