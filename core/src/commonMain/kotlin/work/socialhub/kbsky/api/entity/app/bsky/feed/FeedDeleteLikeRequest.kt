package work.socialhub.kbsky.api.entity.app.bsky.feed


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

/**
 * Uri includes the rkey.
 * so, uri or rkey is enough.
 */
@JsExport
data class FeedDeleteLikeRequest(
    override val auth: AuthProvider,
    override var uri: String? = null,
    override var rkey: String? = null,
) : AuthRequest(auth), RKeyRequest
