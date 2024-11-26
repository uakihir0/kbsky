package work.socialhub.kbsky.stream.app.bsky

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.stream.AbstractTest
import work.socialhub.kbsky.stream.BlueskyStreamFactory
import work.socialhub.kbsky.stream.api.entity.app.bsky.JetStreamSubscribeRequest
import work.socialhub.kbsky.stream.entity.app.bsky.callback.JetStreamEventCallback
import work.socialhub.kbsky.stream.entity.app.bsky.model.Event
import work.socialhub.kbsky.stream.entity.callback.OpenedCallback
import kotlin.test.Test

class JetStreamTest : AbstractTest() {

    @Test
    fun testSubscribeRepo() {
        runBlocking {
            val stream = BlueskyStreamFactory
                .instance()
                .jetStream()
                .subscribe(
                    JetStreamSubscribeRequest().also {
                        it.wantedCollections = listOf("app.bsky.feed.post")
                    }
                )

            stream.eventCallback(
                object : JetStreamEventCallback {
                    override fun onEvent(
                        event: Event
                    ) {
                        event.commit?.record?.asFeedPost?.let {
                            println(it.text)
                        }
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