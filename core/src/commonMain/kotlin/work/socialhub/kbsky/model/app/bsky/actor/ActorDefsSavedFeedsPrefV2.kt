package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsSavedFeedsPrefV2 : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#savedFeedsPrefV2"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var items: List<ActorDefsSavedFeed>
}
