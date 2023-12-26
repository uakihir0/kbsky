package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ActorDefsPreferencesPolymorphicSerializer

/**
 * @see ActorDefsAdultContentPref
 * @see ActorDefsContentLabelPref
 * @see ActorDefsSavedFeedsPref
 */
@Serializable(with = ActorDefsPreferencesPolymorphicSerializer::class)
abstract class ActorDefsPreferencesUnion {
    @SerialName("\$type")
    abstract var type: String
}
