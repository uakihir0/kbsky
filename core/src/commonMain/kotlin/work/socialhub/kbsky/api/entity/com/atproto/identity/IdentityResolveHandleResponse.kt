package work.socialhub.kbsky.api.entity.com.atproto.identity


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * https://github.com/bluesky-social/atproto/blob/main/lexicons/com/atproto/identity/resolveHandle.json
 */
@Serializable
@JsExport
data class IdentityResolveHandleResponse(
    var did: String = "",
)
