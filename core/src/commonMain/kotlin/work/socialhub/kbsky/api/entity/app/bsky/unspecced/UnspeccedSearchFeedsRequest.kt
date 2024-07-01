package work.socialhub.kbsky.api.entity.app.bsky.unspecced

import work.socialhub.kbsky.api.entity.share.MapRequest

class UnspeccedSearchFeedsRequest : MapRequest {
    var q: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("q", q)
        }
    }
}
