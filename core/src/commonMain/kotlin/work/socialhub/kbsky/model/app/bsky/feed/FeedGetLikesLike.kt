package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedGetLikesLike(
    var indexedAt: String = "",
    var createdAt: String = "",
    var actor: ActorDefsProfileView = ActorDefsProfileView(),
)
