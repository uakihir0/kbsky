package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.internal.com.atproto.ATProtocolStreamImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object ATProtocolStreamFactory {

    @JsName("instanceFromUri")
    fun instance(
        pdsUri: String,
        firehoseUri: String,
    ): ATProtocolStream {
        return ATProtocolStreamImpl(
            ATProtocolStreamConfig().also {
                it.pdsUri = pdsUri
                it.firehoseUri = firehoseUri
            })
    }

    @JsName("instanceFromConfig")
    fun instance(
        config: ATProtocolStreamConfig = ATProtocolStreamConfig(),
    ): ATProtocolStream {
        return ATProtocolStreamImpl(config)
    }
}
