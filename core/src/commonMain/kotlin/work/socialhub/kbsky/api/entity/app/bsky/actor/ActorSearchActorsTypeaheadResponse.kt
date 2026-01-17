package work.socialhub.kbsky.api.entity.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorSearchActorsTypeaheadResponse(
    var actors: List<ActorDefsProfileView> = emptyList(),
)
