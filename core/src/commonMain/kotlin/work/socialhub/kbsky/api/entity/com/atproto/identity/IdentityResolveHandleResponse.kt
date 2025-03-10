package work.socialhub.kbsky.api.entity.com.atproto.identity

import kotlinx.serialization.Serializable

/**
 * https://github.com/bluesky-social/atproto/blob/main/lexicons/com/atproto/identity/resolveHandle.json
 */
@Serializable
data class IdentityResolveHandleResponse(
    var did: String
)
