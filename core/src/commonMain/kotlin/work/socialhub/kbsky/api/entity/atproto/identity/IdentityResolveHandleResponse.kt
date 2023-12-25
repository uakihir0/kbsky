package work.socialhub.kbsky.api.entity.atproto.identity

import kotlinx.serialization.Serializable

@Serializable
class IdentityResolveHandleResponse {
    var did: String? = null
}
