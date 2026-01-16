package work.socialhub.kbsky

import work.socialhub.kbsky.stream.ATProtocolStreamFactory
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
class BskyFactory {

    fun stream(
        apiUri: String,
        streamUri: String
    ) = ATProtocolStreamFactory.instance(apiUri, streamUri)

    fun bluesky(uri: String) = BlueskyFactory.instance(uri)

    fun atproto(uri: String) = ATProtocolFactory.instance(uri)

    @JsName("plc")
    fun plc() = PLCDirectoryFactory.instance()

    @JsName("plcFromUri")
    fun plc(uri: String) = PLCDirectoryFactory.instance(uri)

    companion object {

        /**
         * 参照を行わないとフレームワーク内でオミットされるため。
         * Because it is omitted in the framework if no reference is made.
         */
        fun getPLCDirectoryFactory() = PLCDirectoryFactory
        fun getATProtocolStreamFactory() = ATProtocolStreamFactory
        fun getATProtocolFactory() = ATProtocolFactory
        fun getBlueskyFactory() = BlueskyFactory

        fun getATProtocolTypes() = ATProtocolTypes
        fun getBlueSkyTypes() = BlueskyTypes
    }
}