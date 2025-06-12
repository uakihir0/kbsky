package work.socialhub.kbsky.api.entity.app.bsky.video

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.video.JobStatus

/**
 * Response for retrieving video job status.
 */
@Serializable
data class VideoGetJobStatusResponse(
    var jobStatus: JobStatus? = null,
)
