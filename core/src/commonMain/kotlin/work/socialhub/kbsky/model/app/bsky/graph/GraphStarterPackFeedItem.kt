package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.Serializable

@Serializable
data class GraphStarterPackFeedItem(
    /** at-uri */
    var uri: String
)