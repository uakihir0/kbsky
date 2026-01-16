package work.socialhub.kbsky.api.entity.app.bsky.feed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadUnion
import kotlin.js.JsExport

/**
 * Response for a post thread request.
 */
@Serializable
@JsExport
data class FeedGetPostThreadResponse(
    var thread: FeedDefsThreadUnion? = null,
)
