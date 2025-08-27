package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.moderation.ModerationSubjectUnion

/**
 * A URI with a content-hash fingerprint.
 */
@Serializable
data class RepoStrongRef(
    val uri: String = "",
    val cid: String = "",
) : ModerationSubjectUnion() {
    @SerialName("\$type")
    override val type: String = "com.atproto.repo.strongRef"
}
