package work.socialhub.kbsky.api.entity.app.bsky.actor


import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

/**
 * Request for app.bsky.actor.putPreferences.
 *
 * putPreferences replaces the whole preferences of the account, so the preferences are
 * passed as raw JSON elements instead of typed models. This keeps preference types and
 * fields unknown to kbsky (e.g. those added by newer lexicons) as they are.
 * Typically, take the "preferences" array from the raw JSON of getPreferences,
 * modify only the needed elements, and pass it here.
 */
@JsExport
data class ActorPutPreferencesRequest(
    override val auth: AuthProvider,
    val preferences: List<JsonElement>,
) : AuthRequest(auth) {

    fun toJson(): String {
        return buildJsonObject {
            put("preferences", JsonArray(preferences))
        }.toString()
    }
}
