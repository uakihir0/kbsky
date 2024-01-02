package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.internal.atproto._ATProtocolStream

object ATProtocolStreamFactory {
    fun instance(
        apiUri: String,
        streamUri: String,
    ): ATProtocolStream {
        return _ATProtocolStream(apiUri, streamUri)
    }
}
