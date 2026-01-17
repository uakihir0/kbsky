package work.socialhub.kbsky.api.entity.app.bsky.feed


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class FeedGetFeedGeneratorRequest(
    override val auth: AuthProvider,
    /** at-uri  */
    var feed: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feed", feed)
        }
    }
}
