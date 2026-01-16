package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

@JsExport
data class FeedGetFeedGeneratorsRequest(
    override val auth: AuthProvider,
    /** at-uri  */
    var feeds: List<String>? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feeds", feeds)
        }
    }
}
