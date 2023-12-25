package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedDeleteRepostRequest
import work.socialhub.kbsky.api.entity.bsky.feed.FeedRepostRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef
import kotlin.test.Test

class RepostTest : AbstractTest() {

    @Test
    fun testRepost() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
        val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

        val ref = RepoStrongRef(uri, cid)
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed().repost(
                FeedRepostRequest(accessJwt).also {
                    it.subject = ref
                }
            )

        println(response.data.uri)
    }

    @Test
    fun testDeleteRepost() {
        var repostUri: String

        run {
            // Create
            val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
            val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

            val ref = RepoStrongRef(uri, cid)
            val response = BlueskyFactory
                .instance(BSKY_SOCIAL.uri)
                .feed()
                .repost(
                    FeedRepostRequest(accessJwt).also {
                        it.subject = ref
                    }
                )
            repostUri = checkNotNull(response.data.uri)
        }

        run { // Delete
            BlueskyFactory
                .instance(BSKY_SOCIAL.uri)
                .feed()
                .deleteRepost(
                    FeedDeleteRepostRequest(accessJwt).also {
                        it.uri = repostUri
                    }
                )
        }
    }
}
