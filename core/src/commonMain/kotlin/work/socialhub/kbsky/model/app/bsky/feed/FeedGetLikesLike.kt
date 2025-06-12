package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
data class FeedGetLikesLike(
    var indexedAt: String = "",
    var createdAt: String = "",
    var actor: ActorDefsProfileView = ActorDefsProfileView(),
)
