package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic

@Serializable
class FeedDefsReasonRepost {
    var by: ActorDefsProfileViewBasic? = null
    var indexedAt: String? = null
}
