package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostThreadRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadViewPost
import kotlin.test.Test

class GetPostThreadTest : AbstractTest() {

    @Test
    fun testGetThreadPost() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jr4mubjdj322"

        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getPostThread(
                FeedGetPostThreadRequest(accessJwt).also {
                    it.uri = uri
                }
            )


        val union = feeds.data.thread
        if (union is FeedDefsThreadViewPost) {
            var tmp: FeedDefsThreadViewPost = union

            while (true) {
                print(tmp.post)

                val replies = tmp.replies
                if (replies.isNullOrEmpty()) {
                    break
                }

                tmp = replies[0] as FeedDefsThreadViewPost
            }
        }
    }
}
