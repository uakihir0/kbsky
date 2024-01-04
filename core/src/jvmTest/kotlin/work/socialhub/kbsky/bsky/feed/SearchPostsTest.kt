package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedSearchPostsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchPostsTest : AbstractTest() {

    @Test
    fun testSearchPosts() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .searchPosts(
                FeedSearchPostsRequest(
                    accessJwt = accessJwt,
                    q = "SocialHub"
                )
            )

        feeds.data.posts
            .forEach { print(it) }
    }
}