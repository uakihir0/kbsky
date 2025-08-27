package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.moderation.ModerationSubjectUnion

/**
 * A URI with a content-hash fingerprint.
 */
@Serializable
data class RepoStrongRef(
    var uri: String = "",
    var cid: String = "",
) : ModerationSubjectUnion() {
    override val type: String = "com.atproto.repo.strongRef"
    
    override fun toMap(): Map<String, Any> {
        return mapOf(
            "\$type" to type,
            "uri" to uri,
            "cid" to cid
        )
    }
}
