package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class FeedGetLikesLike {
    lateinit var indexedAt: String
    lateinit var createdAt: String
    lateinit var actor: ActorDefsProfileView
}
