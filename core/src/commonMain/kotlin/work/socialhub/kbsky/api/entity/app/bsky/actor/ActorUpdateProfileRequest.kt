package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.model.share.Blob

class ActorUpdateProfileRequest(
    accessJwt: String,
    val displayName: String? = null,
    val description: String? = null,
    val avatar: Blob? = null,
    val banner: Blob? = null,
    // set true if you want to clear the avatar
    val clearBanner: Boolean = false
) : AuthRequest(accessJwt)
