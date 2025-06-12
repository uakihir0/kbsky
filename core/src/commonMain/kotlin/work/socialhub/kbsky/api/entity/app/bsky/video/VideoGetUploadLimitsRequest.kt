package work.socialhub.kbsky.api.entity.app.bsky.video

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

data class VideoGetUploadLimitsRequest(
    override val auth: AuthProvider,
) : AuthRequest(auth)
