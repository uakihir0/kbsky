package kbsky.atproto.repo

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.api.entity.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetRecordTest : AbstractTest() {

    @Test
    fun testGetRecord() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jqcyfp3zt22s"

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .getRecord(
                RepoGetRecordRequest(
                    collection = FeedPost,
                    repo = handle,
                    uri = uri
                )
            )

        println(response.data.value?.type)
    }
}
