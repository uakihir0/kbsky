package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ActorDefsLabelersPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    @SerialName("labelers")
    var labelers: List<ActorDefsLabelerPrefItem>? = null,
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#labelersPref"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}