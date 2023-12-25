package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.util.ATUriParser

interface RKeyRequest {
    var uri: String?
    var rkey: String?

    fun rkey(): String? {
        if (rkey != null) {
            return rkey
        }
        return if (uri != null) {
            ATUriParser.getRKey(uri!!)
        } else null
    }
}