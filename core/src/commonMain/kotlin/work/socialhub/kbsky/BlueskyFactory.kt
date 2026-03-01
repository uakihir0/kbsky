package work.socialhub.kbsky


import work.socialhub.kbsky.internal.BlueskyImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object BlueskyFactory {
    @JsName("instanceFromUri")
    fun instance(uri: String): Bluesky {
        return BlueskyImpl(
            BlueskyConfig()
                .also { it.pdsUri = uri })
    }

    @JsName("instanceFromConfig")
    fun instance(config: BlueskyConfig = BlueskyConfig()): Bluesky {
        return BlueskyImpl(config)
    }
}
