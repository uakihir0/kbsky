package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsViewerState
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsBlockedAuthor(
    var did: String = "",
    var viewer: ActorDefsViewerState? = null,
)
