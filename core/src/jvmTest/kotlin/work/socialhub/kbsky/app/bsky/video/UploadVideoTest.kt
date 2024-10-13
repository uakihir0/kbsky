package work.socialhub.kbsky.app.bsky.video

import org.junit.jupiter.api.Test
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetJobStatusRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetUploadLimitsRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoUploadVideoRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.app.bsky.embed.EmbedVideo
import work.socialhub.kbsky.model.share.Blob

class UploadVideoTest : AbstractTest() {

    @Test
    fun testPostVideoTest() {

        // val stream = javaClass.getResourceAsStream("/video/heavy.mp4")
        val stream = javaClass.getResourceAsStream("/video/light.mp4")
        checkNotNull(stream)

        // Upload Video
        val uploadResponse = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .video()
            .uploadVideo(
                VideoUploadVideoRequest(
                    auth = auth(),
                    bytes = stream.readBytes(),
                )
            )

        // Waiting Job
        var blob: Blob? = null
        for (i in 0 until 60) {

            val statusResponse = BlueskyFactory
                .instance(BSKY_SOCIAL.uri)
                .video()
                .getJobStatus(
                    VideoGetJobStatusRequest(
                        auth = auth(),
                        jobId = uploadResponse.data.jobId,
                    )
                )

            if (statusResponse.data.jobStatus.state == "JOB_STATE_COMPLETED") {
                blob = statusResponse.data.jobStatus.blob
                println("> Video job is completed.")
                break
            }

            // Waiting 1s
            println("> Video job is processing.")
            Thread.sleep(1000)
        }

        // Error
        if (blob == null) {
            throw IllegalStateException("Video process is failed.")
        }

        // Setup Video
        val video = EmbedVideo()
        video.alt = "video test"
        video.video = blob

        // Post With Video
        val response2 = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "動画投稿テスト"
                    it.embed = video
                }
            )

        println(response2.data.uri)
    }


    @Test
    fun testGetUploadLimit() {

        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .video()
            .getUploadLimits(
                VideoGetUploadLimitsRequest(auth())
            )

        println("canUpload:            ${response.data.canUpload}")
        println("remainingDailyVideos: ${response.data.remainingDailyVideos}")
        println("remainingDailyBytes:  ${response.data.remainingDailyBytes}")
        println("message:              ${response.data.message}")
        println("error:                ${response.data.error}")
    }
}