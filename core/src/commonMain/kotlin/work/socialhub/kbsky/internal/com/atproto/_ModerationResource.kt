package work.socialhub.kbsky.internal.com.atproto

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolTypes.ModerationCreateReport
import work.socialhub.kbsky.api.com.atproto.ModerationResource
import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportRequest
import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _ModerationResource(
    private val config: ATProtocolConfig
) : ModerationResource {

    override suspend fun createReport(
        request: ModerationCreateReportRequest
    ): Response<ModerationCreateReportResponse> {
        return proceed<ModerationCreateReportResponse> {
            httpRequest(config)
                .url(xrpc(config, ModerationCreateReport))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun createReportBlocking(
        request: ModerationCreateReportRequest
    ): Response<ModerationCreateReportResponse> = toBlocking { createReport(request) }
}