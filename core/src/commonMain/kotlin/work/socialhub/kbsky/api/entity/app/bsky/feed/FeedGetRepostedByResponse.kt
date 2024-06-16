package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class FeedGetRepostedByResponse {
    lateinit var uri: String
    var cid: String? = null
    var cursor: String? = null
    lateinit var repostedBy: List<work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView>
}
