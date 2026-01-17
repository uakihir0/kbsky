package work.socialhub.kbsky.api.entity.com.atproto.moderation


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.moderation.ModerationReport
import kotlin.js.JsExport

@Serializable
@JsExport
class ModerationCreateReportResponse : ModerationReport()
