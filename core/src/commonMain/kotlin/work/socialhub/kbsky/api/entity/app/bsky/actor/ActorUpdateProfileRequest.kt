package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.share.Blob

class ActorUpdateProfileRequest(
    auth: AuthProvider,
    val displayName: String? = null,
    val description: String? = null,
    val avatar: Blob? = null,
    val banner: Blob? = null,
    // set true if you want to clear the avatar
    val clearBanner: Boolean = false,
    val pinnedPost: RepoStrongRef? = null,
    // set true if you want to clear the pinned post
    val clearPinnedPost: Boolean = false,
) : AuthRequest(auth)
