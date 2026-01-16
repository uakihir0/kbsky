package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ThreadgateAllowUnionPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see FeedThreadgateMentionRule
 * @see FeedThreadgateFollowingRule
 * @see FeedThreadgateFollowerRule
 * @see FeedThreadgateListRule
 */
@Serializable(with = ThreadgateAllowUnionPolymorphicSerializer::class)
@JsExport
abstract class FeedThreadgateAllowUnion {
    @SerialName("\$type")
    abstract var type: String

    val asThreadgateMentionRule get() = this as? FeedThreadgateMentionRule
    val asThreadgateFollowingRule get() = this as? FeedThreadgateFollowingRule
    val asThreadgateFollowerRule get() = this as? FeedThreadgateFollowerRule
    val asThreadgateListRule get() = this as? FeedThreadgateListRule
}
