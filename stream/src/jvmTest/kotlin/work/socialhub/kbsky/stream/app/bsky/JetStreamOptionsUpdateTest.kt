package work.socialhub.kbsky.stream.app.bsky

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.stream.AbstractTest
import work.socialhub.kbsky.stream.BlueskyStreamFactory
import work.socialhub.kbsky.stream.api.entity.app.bsky.JetStreamSubscribeRequest
import work.socialhub.kbsky.stream.entity.app.bsky.callback.JetStreamEventCallback
import work.socialhub.kbsky.stream.entity.app.bsky.model.Event
import work.socialhub.kbsky.stream.entity.callback.ErrorCallback
import work.socialhub.kbsky.stream.entity.callback.OpenedCallback
import kotlin.test.Test

class JetStreamOptionsUpdateTest : AbstractTest() {

    @Test
    fun testSubscribeWithManyDids() {
        runBlocking {
            // 50 以上の DID を指定して requireHello + options_update が使われることを確認
            val manyDids = (1..100).map { "did:plc:testdid${it.toString().padStart(4, '0')}" }

            val stream = BlueskyStreamFactory
                .instance()
                .jetStream()
                .subscribe(
                    JetStreamSubscribeRequest().also {
                        it.wantedCollections = listOf("app.bsky.feed.post")
                        it.wantedDids = manyDids
                    }
                )

            // URL に wantedDids が含まれていないことを確認
            println("URI: ${stream.uri}")
            assert(!stream.uri.contains("wantedDids")) {
                "URL should not contain wantedDids when count > MAX_URL_DIDS"
            }
            assert(stream.uri.contains("requireHello=true")) {
                "URL should contain requireHello=true"
            }
            assert(stream.deferredOptionsUpdate != null) {
                "deferredOptionsUpdate should be set"
            }
            assert(stream.deferredOptionsUpdate!!.wantedDids.size == 100) {
                "deferredOptionsUpdate should contain all DIDs"
            }

            println(">> URL construction test passed.")

            stream.eventCallback(
                object : JetStreamEventCallback {
                    override fun onEvent(event: Event) {
                        event.commit?.record?.asFeedPost?.let {
                            println("Event: ${it.text}")
                        }
                    }
                })

            stream.openedCallback(
                object : OpenedCallback {
                    override fun onOpened() {
                        println(">> opened (options_update sent)")
                    }
                })

            stream.errorCallback(
                object : ErrorCallback {
                    override fun onError(e: Exception) {
                        println(">> error: ${e.message}")
                    }
                })

            launch { stream.open() }.let {
                delay(5000)
                it.cancel()
                stream.close()
            }
        }
    }

    @Test
    fun testSubscribeWithFewDids() {
        runBlocking {
            // 50 以下の DID では従来通り URL パラメータに含まれる
            val fewDids = (1..10).map { "did:plc:testdid${it.toString().padStart(4, '0')}" }

            val stream = BlueskyStreamFactory
                .instance()
                .jetStream()
                .subscribe(
                    JetStreamSubscribeRequest().also {
                        it.wantedCollections = listOf("app.bsky.feed.post")
                        it.wantedDids = fewDids
                    }
                )

            // URL に wantedDids が含まれていることを確認
            println("URI: ${stream.uri}")
            assert(stream.uri.contains("wantedDids")) {
                "URL should contain wantedDids when count <= MAX_URL_DIDS"
            }
            assert(!stream.uri.contains("requireHello")) {
                "URL should not contain requireHello when not needed"
            }
            assert(stream.deferredOptionsUpdate == null) {
                "deferredOptionsUpdate should not be set"
            }

            println(">> URL construction test for few DIDs passed.")

            stream.eventCallback(
                object : JetStreamEventCallback {
                    override fun onEvent(event: Event) {
                        event.commit?.record?.asFeedPost?.let {
                            println("Event: ${it.text}")
                        }
                    }
                })

            stream.openedCallback(
                object : OpenedCallback {
                    override fun onOpened() {
                        println(">> opened (traditional URL params)")
                    }
                })

            launch { stream.open() }.let {
                delay(5000)
                it.cancel()
                stream.close()
            }
        }
    }

    @Test
    fun testManualUpdateOptions() {
        runBlocking {
            val stream = BlueskyStreamFactory
                .instance()
                .jetStream()
                .subscribe(
                    JetStreamSubscribeRequest().also {
                        it.wantedCollections = listOf("app.bsky.feed.post")
                        it.requireHello = true
                    }
                )

            stream.eventCallback(
                object : JetStreamEventCallback {
                    override fun onEvent(event: Event) {
                        event.commit?.record?.asFeedPost?.let {
                            println("Event: ${it.text}")
                        }
                    }
                })

            stream.openedCallback(
                object : OpenedCallback {
                    override fun onOpened() {
                        println(">> opened, manually sending options update")
                    }
                })

            launch { stream.open() }.let {
                delay(2000)
                // 手動で updateOptions を呼ぶ
                stream.updateOptions(
                    wantedCollections = listOf("app.bsky.feed.post"),
                    wantedDids = listOf("did:plc:z72i7hdynmk6r22z27h6tvur"),
                )
                println(">> manual updateOptions sent")
                delay(5000)
                it.cancel()
                stream.close()
            }
        }
    }
}
