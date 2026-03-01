package work.socialhub.kbsky


import work.socialhub.kbsky.internal.ATProtocolImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object ATProtocolFactory {
    @JsName("instanceFromUri")
    fun instance(uri: String): ATProtocol {
        return ATProtocolImpl(
            ATProtocolConfig()
                .also { it.pdsUri = uri })
    }

    @JsName("instanceFromConfig")
    fun instance(config: ATProtocolConfig): ATProtocol {
        return ATProtocolImpl(config)
    }
}
