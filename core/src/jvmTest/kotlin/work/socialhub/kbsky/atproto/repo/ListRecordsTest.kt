package work.socialhub.kbsky.atproto.repo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.BlueskyTypes.FeedLike
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.BlueskyTypes.GraphBlock
import work.socialhub.kbsky.api.entity.atproto.repo.RepoListRecordsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ListRecordsTest : AbstractTest() {

    @Test
    fun testListRecords() {

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = handle,
                    collection = FeedPost,
                ).also {
                    it.reverse = true
                    it.limit = 1
                }
            )

        response.data.records?.forEach {
            println(it.value)
        }
    }

    @Test
    fun testListRecordBlocks() {

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = handle,
                    collection = GraphBlock,
                )
            )

        response.data.records?.forEach {
            println(it.value)
        }
    }

    @Test
    fun testListRecordLikes() {

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = handle,
                    collection = FeedLike,
                )
            )

        response.data.records?.forEach {
            println(it.value)
        }
    }
}
