package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ActorDefsSavedFeedsPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    /** at-url  */
    var pinned: List<String> = emptyList(),
    /** at-url  */
    var saved: List<String> = emptyList(),
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#savedFeedsPref"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, emptyList(), emptyList())
}
