package work.socialhub.kbsky.stream

import io.ktor.http.Url
import work.socialhub.kbsky.stream.internal.app.bsky._BlueskyStream

object BlueskyStreamFactory {

    fun instance(
        jetStreamUri: String,
    ): BlueskyStream {
        return _BlueskyStream(
            BlueskyStreamConfig().also {
                it.jetStreamHost = Url(jetStreamUri).host
            })
    }

    fun instance(
        config: BlueskyStreamConfig = BlueskyStreamConfig(),
    ): BlueskyStream {
        return _BlueskyStream(config)
    }
}