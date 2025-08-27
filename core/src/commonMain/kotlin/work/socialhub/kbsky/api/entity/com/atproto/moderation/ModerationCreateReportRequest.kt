package work.socialhub.kbsky.api.entity.com.atproto.moderation

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.com.atproto.moderation.ModerationSubjectUnion

data class ModerationCreateReportRequest(
    val reasonType: String,
    val reason: String? = null,
    val subject: ModerationSubjectUnion,
    override val auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("reasonType", reasonType)
            it.addParam("reason", reason)
            it.addParam("subject", subject)
        }
    }
}