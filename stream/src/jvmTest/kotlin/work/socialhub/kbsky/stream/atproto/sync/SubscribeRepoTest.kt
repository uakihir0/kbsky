package work.socialhub.kbsky.stream.atproto.sync

import work.socialhub.kbsky.domain.Service.BSKY_NETWORK
import work.socialhub.kbsky.model.share.RecordUnion
import work.socialhub.kbsky.stream.ATProtocolStreamFactory
import work.socialhub.kbsky.stream.AbstractTest
import work.socialhub.kbsky.stream.api.entity.atproto.sync.SyncSubscribeReposRequest
import work.socialhub.kbsky.stream.util.callback.EventCallback
import kotlin.test.Test

class SubscribeRepoTest : AbstractTest() {

    @Test
    fun testSubscribeRepo() {

        val stream = ATProtocolStreamFactory
            .instance(BSKY_NETWORK.uri)
            .sync()
            .subscribeRepos(
                SyncSubscribeReposRequest()
            )

        stream.eventCallback = object : EventCallback {
            override fun onEvent(
                cid: String?,
                uri: String?,
                record: RecordUnion
            ) {
                println(cid)
                println(uri)
                print(record)
            }
        }

        stream.open()
        Thread.sleep(10000)
    }
}
