package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.moderation.ModerationSubjectUnion

/**
 * Repository reference by DID.
 */
@Serializable
data class RepoRef(
    val did: String,
) : ModerationSubjectUnion() {
    override val type: String = "com.atproto.admin.defs#repoRef"
}