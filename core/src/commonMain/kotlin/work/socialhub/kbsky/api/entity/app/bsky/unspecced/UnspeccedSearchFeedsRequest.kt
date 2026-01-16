package work.socialhub.kbsky.api.entity.app.bsky.unspecced

import work.socialhub.kbsky.api.entity.share.MapRequest

@JsExport
data class UnspeccedSearchFeedsRequest(
    var q: String? = null,
) : MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("q", q)
        }
    }
}
