package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetActorLikesTest : AbstractTest() {

    @Test
    fun testGetActorLikes() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getActorLikes(
                FeedGetActorLikesRequest(accessJwt).also {
                    it.actor = "uakihir0.com"
                    it.limit = 10
                }
            )

        feeds.data.feed.forEach {
            print(it.post)
        }
    }
}