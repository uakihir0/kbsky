package work.socialhub.kbsky.internal.com.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolTypes.ModerationCreateReport
import work.socialhub.kbsky.api.com.atproto.ModerationResource
import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportRequest
import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _ModerationResource(
    private val config: ATProtocolConfig
) : ModerationResource {

    override fun createReport(
        request: ModerationCreateReportRequest
    ): Response<ModerationCreateReportResponse> {
        return proceed<ModerationCreateReportResponse> {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ModerationCreateReport))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }
}