package work.socialhub.kbsky.api.entity.app.bsky.actor


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class ActorGetPreferencesRequest(
    override val auth: AuthProvider,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> = emptyMap()
}
