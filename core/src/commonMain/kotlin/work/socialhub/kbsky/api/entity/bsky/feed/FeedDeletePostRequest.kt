package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest

/**
 * Uri includes the rkey.
 * so, uri or rkey is enough.
 */
class FeedDeletePostRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), RKeyRequest {

    override var uri: String? = null
    override var rkey: String? = null
}
