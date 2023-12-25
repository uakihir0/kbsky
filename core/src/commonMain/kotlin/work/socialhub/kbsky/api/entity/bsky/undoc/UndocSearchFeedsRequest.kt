package work.socialhub.kbsky.api.entity.bsky.undoc

import work.socialhub.kbsky.api.entity.share.MapRequest

class UndocSearchFeedsRequest : MapRequest {
    var q: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("q", q)
        }
    }
}
