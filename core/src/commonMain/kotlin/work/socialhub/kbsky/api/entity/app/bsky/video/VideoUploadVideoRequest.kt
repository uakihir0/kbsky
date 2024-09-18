package work.socialhub.kbsky.api.entity.app.bsky.video

import work.socialhub.kbsky.api.entity.share.AuthRequest

class VideoUploadVideoRequest(
    accessJwt: String,
    var bytes: ByteArray,
    var name: String = "data.mp4",
    var contentType: String = "video/mp4",
) : AuthRequest(accessJwt)
