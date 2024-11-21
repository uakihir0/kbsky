package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsLabelersPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#labelersPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    @SerialName("labelers")
    var labelers: List<ActorDefsLabelerPrefItem>? = null
}