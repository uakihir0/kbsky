package work.socialhub.kbsky.stream.atproto.sync

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.model.share.RecordUnion
import work.socialhub.kbsky.stream.ATProtocolStreamFactory
import work.socialhub.kbsky.stream.AbstractTest
import work.socialhub.kbsky.stream.api.entity.com.atproto.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.entity.callback.OpenedCallback
import work.socialhub.kbsky.stream.entity.com.atproto.callback.SyncEventCallback
import kotlin.test.Test

class SubscribeRepoTest : AbstractTest() {

    @Test
    fun testSubscribeRepo() {
        runBlocking {
            val stream = ATProtocolStreamFactory
                .instance()
                .sync()
                .subscribeRepos(
                    SyncSubscribeReposRequest().also {
                        it.filter = listOf(
                            "app.bsky.feed.post"
                        )
                    }
                )

            stream.eventCallback(
                object : SyncEventCallback {
                    override fun onEvent(
                        cid: String?,
                        uri: String?,
                        record: RecordUnion
                    ) {
                        print(record)
                    }
                })

            stream.openedCallback(
                object : OpenedCallback {
                    override fun onOpened() {
                        println(">> opened.")
                    }
                })


            launch { stream.open() }.let {
                delay(10000)
                it.cancel()
                stream.close()
            }
        }
    }
}
