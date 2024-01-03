package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetRepostedByRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetRepostedByTest : AbstractTest() {

    @Test
    fun testGetRepostedBy() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jr7b5svzuc2q"

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getRepostedBy(
                FeedGetRepostedByRequest(accessJwt).also {
                    it.uri = uri
                }
            )

        response.data.repostedBy.forEach {
            println("------------------------------")
            println(it.displayName)
            println(it.handle)
            println(it.avatar)
        }
    }
}
