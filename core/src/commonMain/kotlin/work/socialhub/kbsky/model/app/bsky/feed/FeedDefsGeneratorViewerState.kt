package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsGeneratorViewerState(
    /** at-url  */
    var like: String? = null,
)
