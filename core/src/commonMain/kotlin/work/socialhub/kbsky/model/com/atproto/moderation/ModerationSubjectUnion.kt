package work.socialhub.kbsky.model.com.atproto.moderation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoRef
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef

/**
 * @see RepoRef
 * @see RepoStrongRef
 */
@Serializable(with = ModerationSubjectUnionSerializer::class)
abstract class ModerationSubjectUnion {
    @SerialName("\$type")
    abstract val type: String

    abstract fun toMap(): Map<String, Any>

    val asRef get() = this as? RepoRef
    val asStrongRef get() = this as? RepoStrongRef
}
