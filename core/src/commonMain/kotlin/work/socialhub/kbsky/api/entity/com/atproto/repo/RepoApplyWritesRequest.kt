package work.socialhub.kbsky.api.entity.com.atproto.repo


import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility
import kotlin.js.JsExport

@JsExport
data class RepoApplyWritesRequest(
    override val auth: AuthProvider,
    /** The operations to apply (create / update / delete). */
    var writes: List<RepoApplyWritesWrite>,
    /** The handle or DID of the repo. If null, the DID of the auth is used. */
    var repo: String? = null,
    /** Validate the records? */
    var validate: Boolean? = null,
    /** If provided, the entire operation will fail if the current repo commit CID does not match this value. */
    var swapCommit: String? = null,
) : AuthRequest(auth) {

    fun toJsonObject(): JsonObject {
        return buildJsonObject {
            put("repo", JsonPrimitive(repo ?: auth.did))
            validate?.let { put("validate", JsonPrimitive(it)) }
            put("writes", JsonArray(writes.map { it.toJsonObject() }))
            swapCommit?.let { put("swapCommit", JsonPrimitive(it)) }
        }
    }

    fun toMappedJson(): String {
        return InternalUtility.json.encodeToString(
            JsonObject.serializer(),
            toJsonObject(),
        )
    }
}
