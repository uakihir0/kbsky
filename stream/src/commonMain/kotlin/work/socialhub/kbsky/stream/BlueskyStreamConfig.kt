package work.socialhub.kbsky.stream

import work.socialhub.kbsky.BlueskyConfig

class BlueskyStreamConfig : BlueskyConfig() {

    var jetStreamHost: String? = null

    companion object {
        val defaultJetStreamHosts = listOf(
            "jetstream1.us-east.bsky.network",
            "jetstream2.us-east.bsky.network",
            "jetstream1.us-west.bsky.network",
            "jetstream2.us-west.bsky.network",
        )
    }
}