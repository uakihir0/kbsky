package work.socialhub.kbsky.api.com.atproto

import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportRequest
import work.socialhub.kbsky.api.entity.com.atproto.moderation.ModerationCreateReportResponse
import work.socialhub.kbsky.api.entity.share.Response

/**
 * ATProtocol/Moderation
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/moderation)
 */
interface ModerationResource {

    /**
     * レポートを作成する
     */
    fun createReport(
        request: ModerationCreateReportRequest
    ): Response<ModerationCreateReportResponse>
}