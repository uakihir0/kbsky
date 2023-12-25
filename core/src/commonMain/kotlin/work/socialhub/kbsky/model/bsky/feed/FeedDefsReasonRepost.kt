package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewBasic

@Serializable
class FeedDefsReasonRepost {
    var by: ActorDefsProfileViewBasic? = null
    var indexedAt: String? = null
}
