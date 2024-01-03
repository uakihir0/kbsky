package work.socialhub.kbsky.api.entity.atproto.identity

import kotlinx.serialization.Serializable

/**
 * https://github.com/bluesky-social/atproto/blob/main/lexicons/com/atproto/identity/resolveHandle.json
 */
@Serializable
class IdentityResolveHandleResponse {
    lateinit var did: String
}
