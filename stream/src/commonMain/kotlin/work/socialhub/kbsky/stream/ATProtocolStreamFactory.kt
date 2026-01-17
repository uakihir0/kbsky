package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.internal.com.atproto._ATProtocolStream
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object ATProtocolStreamFactory {

    @JsName("instanceFromUri")
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

    @JsName("instanceFromConfig")
    fun instance(
        config: ATProtocolStreamConfig = ATProtocolStreamConfig(),
    ): ATProtocolStream {
        return _ATProtocolStream(config)
    }
}
