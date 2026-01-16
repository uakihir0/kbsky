package work.socialhub.kbsky


import work.socialhub.kbsky.internal._Bluesky
import kotlin.js.JsExport

@JsExport
object BlueskyFactory {
    fun instance(uri: String): Bluesky {
        return _Bluesky(
            BlueskyConfig()
                .also { it.pdsUri = uri })
    }

    fun instance(config: BlueskyConfig = BlueskyConfig()): Bluesky {
        return _Bluesky(config)
    }
}
