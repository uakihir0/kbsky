package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest

/**
 * Uri includes the rkey.
 * so, uri or rkey is enough.
 */
class FeedDeletePostRequest(
    accessJwt: String
) : AuthRequest(accessJwt), RKeyRequest {

    override var uri: String? = null
    override var rkey: String? = null
}
