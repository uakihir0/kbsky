package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
@JsExport
data class GraphGetMutesResponse(
    var cursor: String? = null,
    var mutes: List<ActorDefsProfileView> = emptyList(),
)
