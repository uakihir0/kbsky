package work.socialhub.kbsky.api.entity.app.bsky.video


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class VideoGetJobStatusRequest(
    override val auth: AuthProvider,
    val jobId: String,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("jobId", jobId)
        }
    }
}
