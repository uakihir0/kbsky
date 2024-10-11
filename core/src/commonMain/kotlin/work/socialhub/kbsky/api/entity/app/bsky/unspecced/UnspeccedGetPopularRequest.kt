package work.socialhub.kbsky.api.entity.app.bsky.unspecced

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class UnspeccedGetPopularRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    var includeNsfw: Boolean? = null
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("includeNsfw", includeNsfw)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
