package work.socialhub.kbsky.api.entity.app.bsky.actor


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class ActorGetProfilesRequest(
    override val auth: AuthProvider,
    var actors: List<String>? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("actors", actors)
        }
    }
}
