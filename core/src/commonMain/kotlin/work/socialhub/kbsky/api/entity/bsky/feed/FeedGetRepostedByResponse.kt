package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class FeedGetRepostedByResponse {
    lateinit var uri: String
    var cid: String? = null
    var cursor: String? = null
    lateinit var repostedBy: List<ActorDefsProfileView>
}
