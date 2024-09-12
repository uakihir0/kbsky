package work.socialhub.kbsky.api.entity.app.bsky.video

import work.socialhub.kbsky.api.entity.share.AuthRequest

class VideoGetUploadLimitsRequest(
    accessJwt: String,
) : AuthRequest(accessJwt)
