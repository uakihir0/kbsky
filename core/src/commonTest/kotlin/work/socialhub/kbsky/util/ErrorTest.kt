package work.socialhub.kbsky.util

import work.socialhub.kbsky.ATProtocolException
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ErrorTest() {

    @Test
    fun testError() {

        try {
            BlueskyFactory
                .instance(BSKY_SOCIAL.uri)
                .feed()
                .getActorFeeds(
                    FeedGetActorFeedsRequest(
                        BearerTokenAuthProvider("INVALID")
                    )
                )

        } catch (e: ATProtocolException) {
            println(e.status)
            println(e.response?.message)
            println(e.response?.error)
        }
    }
}