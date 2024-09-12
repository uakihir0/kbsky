package work.socialhub.kbsky.model.app.bsky.video

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
data class JobStatus(
    val jobId: String,
    val did: String,
    // The state of the video processing job. All values not listed as a known value indicate that the job is in process.
    // ["JOB_STATE_COMPLETED", "JOB_STATE_FAILED"]
    val state: String,
    val progress: Int? = null,
    val blob: Blob? = null,
    val error: String? = null,
    val message: String? = null,
)