package work.socialhub.kbsky


import work.socialhub.kbsky.internal._Bluesky
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object BlueskyFactory {
    @JsName("instanceFromUri")
    fun instance(uri: String): Bluesky {
        return _Bluesky(
            BlueskyConfig()
                .also { it.pdsUri = uri })
    }

    @JsName("instanceFromConfig")
    fun instance(config: BlueskyConfig = BlueskyConfig()): Bluesky {
        return _Bluesky(config)
    }
}
