package work.socialhub.kbsky

open class BlueskyConfig : ATProtocolConfig() {

    var videoServiceUri: String = "https://video.bsky.app/"
    var videoServiceDid: String = "did:web:video.bsky.app"
}