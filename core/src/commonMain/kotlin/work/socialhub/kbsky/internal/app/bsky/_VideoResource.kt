package work.socialhub.kbsky.internal.app.bsky

import io.ktor.http.URLBuilder
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.VideoGetJobStatus
import work.socialhub.kbsky.BlueskyTypes.VideoGetUploadLimits
import work.socialhub.kbsky.BlueskyTypes.VideoUploadVideo
import work.socialhub.kbsky.api.app.bsky.VideoResource
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetJobStatusRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetJobStatusResponse
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetUploadLimitsRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoGetUploadLimitsResponse
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoUploadVideoRequest
import work.socialhub.kbsky.api.entity.app.bsky.video.VideoUploadVideoResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetServiceAuthRequest
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.com.atproto._ServerResource
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _VideoResource(
    private val config: BlueskyConfig
) : VideoResource {

    override fun getJobStatus(
        request: VideoGetJobStatusRequest
    ): Response<VideoGetJobStatusResponse> {

        // get token for video service
        val videoToken = getVideoTokenFromPds(config, request.accessJwt, VIDEO_SERVICE_DID, VideoGetJobStatus)

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config.also { it.pdsUri = VIDEO_SERVICE }, VideoGetJobStatus))
                    .header("Authorization", videoToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getUploadLimits(
        request: VideoGetUploadLimitsRequest
    ): Response<VideoGetUploadLimitsResponse> {

        // get token for video service
        val videoToken = getVideoTokenFromPds(config, request.accessJwt, VIDEO_SERVICE_DID, VideoGetUploadLimits)

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config.also { it.pdsUri = VIDEO_SERVICE }, VideoGetUploadLimits))
                    .header("Authorization", videoToken)
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }

    override fun uploadVideo(
        request: VideoUploadVideoRequest
    ): Response<VideoUploadVideoResponse> {

        // get token for uploadVideo
        // (note: own pds as aud, "uploadBlob" as lxm required)
        val videoToken = getVideoTokenFromPds(
            config,
            request.accessJwt,
            aud = AuthRequest(request.accessJwt).jwt.aud,
            lxm = "com.atproto.repo.uploadBlob"
        )

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(
                        URLBuilder(xrpc(config.also { it.pdsUri = VIDEO_SERVICE }, VideoUploadVideo))
                            .also {
                                it.parameters.append("did", request.did)
                                it.parameters.append("name", request.name)
                            }
                            .buildString()
                    )
                    .header("Authorization", videoToken)
                    .header("Content-Type", request.contentType)
                    .accept(MediaType.JSON)
                    .file(
                        key = "file",
                        fileName = request.name,
                        fileBody = request.bytes
                    )
                    .post()
            }
        }
    }

    private fun getVideoTokenFromPds(config: BlueskyConfig, accessJwt: String, aud: String, lxm: String): String {

        val videoTokenResponse =
            _ServerResource(config)
                .getServiceAuth(
                    ServerGetServiceAuthRequest(
                        accessJwt = accessJwt,
                        aud = aud,
                        lxm = lxm
                    )
                )

        return AuthRequest(videoTokenResponse.data.token).bearerToken
    }

    companion object {
        private const val VIDEO_SERVICE = "https://video.bsky.app/"
        private const val VIDEO_SERVICE_DID = "did:web:video.bsky.app"
    }
}
