package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.model.app.bsky.graph.GraphStarterPackView

@Serializable
data class GraphGetStarterPacksResponse (
    var starterPacks: List<FeedDefsPostView>
)
