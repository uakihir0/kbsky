package work.socialhub.kbsky.stream.api.entity.app.bsky

class JetStreamSubscribeRequest {

    var host: String? = null

    /**
     * wantedCollections supports NSID path prefixes
     * i.e. app.bsky.graph.*, or app.bsky.*.
     *
     * app.bsky.feed.like
     *
     */
    var wantedCollections: List<String> = listOf()

    /**
     * An array of Repo DIDs to filter which records you receive on your stream
     * (Default empty = all repos)
     */
    var wantedDids: List<String> = listOf()

    /**
     * The maximum size of a payload that this client would like to receive.
     * Zero means no limit, negative values are treated as zero.
     * (Default "0" or empty = no maximum size)
     */
    var maxMessageSizeBytes: Long? = null

    /**
     * A unix microseconds timestamp cursor to begin playback from.
     * n absent cursor or a cursor from the future will result in live-tail operation.
     * When reconnecting, use the time_us from your most recently processed event
     * and maybe provide a negative buffer (i.e. subtract a few seconds) to ensure gapless playback
     */
    var cursor: Long? = null

    /**
     * Set to true to enable zstd compression.
     * FIXME: Unless there is a Kotlin Multiplatform library that supports this compressed format.
     * FIXME: この圧縮フォーマットに対応している Kotlin Multiplatform ライブラリが出ない限りは対応不可
     */
    // var compress: Boolean = false

    /**
     * Set to true to pause replay/live-tail until the server recevies
     * a SubscriberOptionsUpdatePayload over the socket in a Subscriber Sourced Message
     */
    var requireHello: Boolean? = null
}