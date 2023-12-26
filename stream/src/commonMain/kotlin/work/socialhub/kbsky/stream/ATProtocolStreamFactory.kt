package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.internal.atproto._ATProtocolStream

object ATProtocolStreamFactory {
    fun instance(uri: String): _ATProtocolStream {
        return _ATProtocolStream(uri)
    }
}
