package work.socialhub.kbsky.api.entity.app.bsky.video


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class VideoUploadVideoRequest(
    override val auth: AuthProvider,
    var bytes: ByteArray,
    var name: String = "data.mp4",
    var contentType: String = "video/mp4",
) : AuthRequest(auth)
