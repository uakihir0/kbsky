package work.socialhub.kbsky.api.entity.app.bsky.video

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class VideoGetJobStatusRequest(
    accessJwt: String,
    val jobId: String
) : AuthRequest(accessJwt), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("jobId", jobId)
        }
    }
}
