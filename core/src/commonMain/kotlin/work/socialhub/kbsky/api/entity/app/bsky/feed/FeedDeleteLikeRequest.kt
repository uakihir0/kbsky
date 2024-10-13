package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest
import work.socialhub.kbsky.auth.AuthProvider

/**
 * Uri includes the rkey.
 * so, uri or rkey is enough.
 */
class FeedDeleteLikeRequest(
    auth: AuthProvider
) : AuthRequest(auth), RKeyRequest {

    override var uri: String? = null
    override var rkey: String? = null
}
