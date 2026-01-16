package work.socialhub.kbsky.api.entity.share


import work.socialhub.kbsky.util.ATUriParser
import kotlin.js.JsExport

@JsExport
interface RKeyRequest {
    var uri: String?
    var rkey: String?

    @JsExport.Ignore
    fun rkey(): String? {
        if (rkey != null) {
            return rkey
        }
        return if (uri != null) {
            ATUriParser.getRKey(uri!!)
        } else null
    }
}
