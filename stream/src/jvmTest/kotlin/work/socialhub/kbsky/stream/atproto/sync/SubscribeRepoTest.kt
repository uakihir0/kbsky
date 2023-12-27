package work.socialhub.kbsky.stream.atproto.sync

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.domain.Service.BSKY_NETWORK
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.share.RecordUnion
import work.socialhub.kbsky.stream.ATProtocolStreamFactory
import work.socialhub.kbsky.stream.AbstractTest
import work.socialhub.kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.util.callback.EventCallback
import kotlin.test.Test

class SubscribeRepoTest : AbstractTest() {

    @Test
    fun testSubscribeRepo() {
        runBlocking {
            val stream = ATProtocolStreamFactory
                .instance(
                    apiUri = BSKY_SOCIAL.uri,
                    streamUri = BSKY_NETWORK.uri
                )
                .sync()
                .subscribeRepos(
                    SyncSubscribeReposRequest().also {
                        it.filter = listOf(
                            "app.bsky.feed.post"
                        )
                    }
                )

            stream.eventCallback(
                object : EventCallback {
                    override fun onEvent(
                        cid: String?,
                        uri: String?,
                        record: RecordUnion
                    ) {
                        print(record)
                    }
                })

            println("Blocked")
            stream.open()
            println("Releaseed")
            Thread.sleep(10000)
        }
    }
}
