package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ThreadgateAllowUnionPolymorphicSerializer

/**
 * @see ThreadgateMentionRule
 * @see ThreadgateFollowingRule
 * @see ThreadgateListRule
 */
@Serializable(with = ThreadgateAllowUnionPolymorphicSerializer::class)
abstract class ThreadgateAllowUnion {
    @SerialName("\$type")
    abstract var type: String

    val asThreadgateMentionRule get() = this as? ThreadgateMentionRule
    val asThreadgateFollowingRule get() = this as? ThreadgateFollowingRule
    val asThreadgateListRule get() = this as? ThreadgateListRule
}
