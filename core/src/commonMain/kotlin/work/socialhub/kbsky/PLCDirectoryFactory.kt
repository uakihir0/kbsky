package work.socialhub.kbsky


import work.socialhub.kbsky.internal.PLCDirectoryImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object PLCDirectoryFactory {
    @JsName("instance")
    fun instance(): PLCDirectory {
        return PLCDirectoryImpl("https://plc.directory/")
    }

    @JsName("instanceFromUri")
    fun instance(uri: String): PLCDirectory {
        return PLCDirectoryImpl(uri)
    }
}
