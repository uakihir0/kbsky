package work.socialhub.kbsky.api.entity.app.bsky.graph


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphGetBlocksResponse(
    var cursor: String? = null,
    var blocks: List<ActorDefsProfileView> = emptyList(),
)
