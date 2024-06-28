package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ThreadgateAllowUnionPolymorphicSerializer

/**
 * @see FeedThreadgateMentionRule
 * @see FeedThreadgateFollowingRule
 * @see FeedThreadgateListRule
 */
@Serializable(with = ThreadgateAllowUnionPolymorphicSerializer::class)
abstract class FeedThreadgateAllowUnion {
    @SerialName("\$type")
    abstract var type: String

    val asThreadgateMentionRule get() = this as? FeedThreadgateMentionRule
    val asThreadgateFollowingRule get() = this as? FeedThreadgateFollowingRule
    val asThreadgateListRule get() = this as? FeedThreadgateListRule
}
