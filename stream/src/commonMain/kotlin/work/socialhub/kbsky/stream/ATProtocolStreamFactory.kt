package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.internal.com.atproto._ATProtocolStream

object ATProtocolStreamFactory {

    fun instance(
        pdsUri: String,
        firehoseUri: String,
    ): ATProtocolStream {
        return _ATProtocolStream(
            ATProtocolStreamConfig().also {
                it.pdsUri = pdsUri
                it.firehoseUri = firehoseUri
            })
    }

    fun instance(
        config: ATProtocolStreamConfig = ATProtocolStreamConfig(),
    ): ATProtocolStream {
        return _ATProtocolStream(config)
    }
}
