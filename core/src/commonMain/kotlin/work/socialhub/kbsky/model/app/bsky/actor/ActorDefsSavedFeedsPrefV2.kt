package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsSavedFeedsPrefV2(
    @SerialName("\$type")
    override var type: String = TYPE,
    var items: List<ActorDefsSavedFeed> = emptyList(),
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#savedFeedsPrefV2"
    }
}
