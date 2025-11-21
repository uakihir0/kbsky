package work.socialhub.kbsky.com.atproto.repo

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyTypes.FeedLike
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.BlueskyTypes.GraphBlock
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoListRecordsRequest
import kotlin.test.Test

class ListRecordsTest() : AbstractTest() {

    companion object {
        const val handle = "uakihir0.com"
    }

    @Test
    fun testListRecords() {

        val response = client()
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = ListRecordsTest.handle,
                    collection = FeedPost,
                ).also {
                    it.reverse = true
                    it.limit = 1
                }
            )

        response.data.records.forEach {
            print(checkNotNull(it.value))
        }
    }

    @Test
    fun testListRecordBlocks() {

        val response = client()
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = ListRecordsTest.handle,
                    collection = GraphBlock,
                )
            )

        response.data.records.forEach {
            print(checkNotNull(it.value))
        }
    }

    @Test
    fun testListRecordLikes() {

        val response = client()
            .repo()
            .listRecords(
                RepoListRecordsRequest(
                    repo = ListRecordsTest.handle,
                    collection = FeedLike,
                )
            )

        response.data.records.forEach {
            print(checkNotNull(it.value))
        }
    }
}
