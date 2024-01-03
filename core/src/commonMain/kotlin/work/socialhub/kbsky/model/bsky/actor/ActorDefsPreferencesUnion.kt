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

    fun personalDetailsPref() = this as? ActorDefsPersonalDetailsPref
    fun adultContentPref() = this as? ActorDefsAdultContentPref
    fun contentLabelPref() = this as? ActorDefsContentLabelPref
    fun savedFeedsPref() = this as? ActorDefsSavedFeedsPref
    fun feedViewPref() = this as? ActorDefsFeedViewPref
    fun threadViewPref() = this as? ActorDefsThreadViewPref
}
