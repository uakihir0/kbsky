package work.socialhub.kbsky


import work.socialhub.kbsky.internal._PLCDirectory
import kotlin.js.JsExport
import kotlin.js.JsName

@JsExport
object PLCDirectoryFactory {
    @JsName("instance")
    fun instance(): PLCDirectory {
        return _PLCDirectory("https://plc.directory/")
    }

    @JsName("instanceFromUri")
    fun instance(uri: String): PLCDirectory {
        return _PLCDirectory(uri)
    }
}
