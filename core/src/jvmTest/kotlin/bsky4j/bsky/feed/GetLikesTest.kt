package kbsky.bsky.feed

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetLikesRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class GetLikesTest : AbstractTest() {

    @Test
    fun testLikes() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jt5ao4gpxc2u"

        val feeds = BlueskyFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .feed()
            .getLikes(
                FeedGetLikesRequest(accessJwt).also {
                    it.uri = uri
                }
            )

        checkNotNull(feeds.data.likes).forEach {
            print(checkNotNull(it.actor))
        }
    }
}
