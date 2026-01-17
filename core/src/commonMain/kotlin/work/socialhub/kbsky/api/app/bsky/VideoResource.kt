package work.socialhub.kbsky.api.app.bsky


import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetJobStatusRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetJobStatusResponse
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetUploadLimitsRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetUploadLimitsResponse
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoUploadVideoRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoUploadVideoResponse
import work.socialhub.kbsky.api.entity.share.Response
import kotlin.js.JsExport

/**
 * Bluesky/Video
 */
@JsExport
interface VideoResource {

    /**
     * Get status details for a video processing job.
     */
    suspend fun getJobStatus(
        request: VideoGetJobStatusRequest
    ): Response<VideoGetJobStatusResponse>

    @JsExport.Ignore
    fun getJobStatusBlocking(
        request: VideoGetJobStatusRequest
    ): Response<VideoGetJobStatusResponse>

    /**
     * Get video upload limits for the authenticated user.
     */
    suspend fun getUploadLimits(
        request: VideoGetUploadLimitsRequest
    ): Response<VideoGetUploadLimitsResponse>

    @JsExport.Ignore
    fun getUploadLimitsBlocking(
        request: VideoGetUploadLimitsRequest
    ): Response<VideoGetUploadLimitsResponse>

    /**
     * Upload a video to be processed then stored on the PDS.
     */
    suspend fun uploadVideo(
        request: VideoUploadVideoRequest
    ): Response<VideoUploadVideoResponse>

    @JsExport.Ignore
    fun uploadVideoBlocking(
        request: VideoUploadVideoRequest
    ): Response<VideoUploadVideoResponse>
}
