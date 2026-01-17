package work.socialhub.kbsky


import kotlin.js.JsExport

@JsExport
open class BlueskyConfig : ATProtocolConfig() {

    var videoServiceUri: String = "https://video.bsky.app/"
    var videoServiceDid: String = "did:web:video.bsky.app"
}
