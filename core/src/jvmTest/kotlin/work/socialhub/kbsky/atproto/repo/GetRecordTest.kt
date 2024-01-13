package work.socialhub.kbsky.atproto.repo

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.api.entity.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetRecordTest : AbstractTest() {

    @Test
    fun testGetRecord() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jqcyfp3zt22s"

        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .getRecord(
                RepoGetRecordRequest(
                    collection = FeedPost,
                    repo = handle,
                    uri = uri
                )
            )

        print(checkNotNull(response.data.value))
    }
}
