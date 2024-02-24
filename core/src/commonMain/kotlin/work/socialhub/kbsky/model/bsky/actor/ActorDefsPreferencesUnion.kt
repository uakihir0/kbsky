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
 * @see ActorDefsThreadViewPref
 */
@Serializable(with = ActorDefsPreferencesPolymorphicSerializer::class)
abstract class ActorDefsPreferencesUnion {
    @SerialName("\$type")
    abstract var type: String

    val asPersonalDetailsPref get() = this as? ActorDefsPersonalDetailsPref
    val asAdultContentPref get() = this as? ActorDefsAdultContentPref
    val asContentLabelPref get() = this as? ActorDefsContentLabelPref
    val asSavedFeedsPref get() = this as? ActorDefsSavedFeedsPref
    val asFeedViewPref get() = this as? ActorDefsFeedViewPref
    val asThreadViewPref get() = this as? ActorDefsThreadViewPref
}
