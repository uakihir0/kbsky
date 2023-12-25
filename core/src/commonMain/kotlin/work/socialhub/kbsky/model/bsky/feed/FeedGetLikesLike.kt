package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class FeedGetLikesLike {
    var indexedAt: String? = null
    var createdAt: String? = null
    var actor: ActorDefsProfileView? = null
}
