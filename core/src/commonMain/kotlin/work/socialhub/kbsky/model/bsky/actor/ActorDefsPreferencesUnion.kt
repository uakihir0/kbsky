package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ActorDefsPreferencesPolymorphicSerializer

/**
 * @see ActorDefsPersonalDetailsPref
 * @see ActorDefsAdultContentPref
 * @see ActorDefsContentLabelPref
 * @see ActorDefsSavedFeedsPref
 * @see ActorDefsFeedViewPref
 */
@Serializable(with = ActorDefsPreferencesPolymorphicSerializer::class)
abstract class ActorDefsPreferencesUnion {
    @SerialName("\$type")
    abstract var type: String
}
