package work.socialhub.kbsky.api.entity.app.bsky.graph


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class GraphDeleteFollowRequest(
    override val auth: AuthProvider,
    override var uri: String? = null,
    override var rkey: String? = null,
) : AuthRequest(auth), RKeyRequest
