package work.socialhub.kbsky.stream

import io.ktor.http.Url
import work.socialhub.kbsky.stream.internal.app.bsky.BlueskyStreamImpl

object BlueskyStreamFactory {

    fun instance(
        jetStreamUri: String,
    ): BlueskyStream {
        return BlueskyStreamImpl(
            BlueskyStreamConfig().also {
                it.jetStreamHost = Url(jetStreamUri).host
            })
    }

    fun instance(
        config: BlueskyStreamConfig = BlueskyStreamConfig(),
    ): BlueskyStream {
        return BlueskyStreamImpl(config)
    }
}