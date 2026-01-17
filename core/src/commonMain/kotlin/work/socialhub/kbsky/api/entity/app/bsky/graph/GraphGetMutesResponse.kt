package work.socialhub.kbsky.api.entity.app.bsky.graph


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphGetMutesResponse(
    var cursor: String? = null,
    var mutes: List<ActorDefsProfileView> = emptyList(),
)
