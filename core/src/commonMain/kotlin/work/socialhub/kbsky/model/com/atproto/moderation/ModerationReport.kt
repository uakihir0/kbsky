package work.socialhub.kbsky.model.com.atproto.moderation

import kotlinx.serialization.Serializable

@Serializable
open class ModerationReport {
    val id: Int? = null
    val reasonType: String? = null
    val reason: String? = null
    val subject: ModerationSubjectUnion? = null
    val reportedBy: String? = null
    val createdAt: String? = null
}