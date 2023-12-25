package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName

/**
 * @see FeedDefsThreadViewPost
 * @see FeedDefsNotFoundPost
 */
interface FeedDefsThreadUnion {
    @SerialName("\$type")
    val type: String
}
