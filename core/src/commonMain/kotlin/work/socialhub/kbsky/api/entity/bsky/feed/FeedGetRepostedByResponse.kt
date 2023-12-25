package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

class FeedGetRepostedByResponse {
    lateinit var uri: String

    var cid: String? = null
    var cursor: String? = null
    var repostedBy: List<ActorDefsProfileView>? = null
}
