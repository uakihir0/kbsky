package work.socialhub.kbsky.api.entity.app.bsky.feed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedGetRepostedByResponse(
    var uri: String = "",
    var cid: String? = null,
    var cursor: String? = null,
    var repostedBy: List<ActorDefsProfileView> = emptyList(),
)
