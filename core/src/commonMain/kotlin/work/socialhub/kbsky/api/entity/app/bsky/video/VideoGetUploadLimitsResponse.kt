package work.socialhub.kbsky.api.entity.app.bsky.video

import kotlinx.serialization.Serializable

@Serializable
data class VideoGetUploadLimitsResponse(
    val canUpload: Boolean,
    val remainingDailyVideos: Int? = null,
    val remainingDailyBytes: Long? = null,
    val message: String? = null,
    val error: String? = null,
)
