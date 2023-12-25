package work.socialhub.kbsky.api.entity.bsky.graph

import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

class GraphGetFollowersResponse {
    // region
    var subject: ActorDefsProfileView? = null
    var cursor: String? = null

    // endregion
    var followers: List<ActorDefsProfileView>? = null
}
