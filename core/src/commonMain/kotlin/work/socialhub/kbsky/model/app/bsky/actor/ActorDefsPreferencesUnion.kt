package work.socialhub.kbsky.model.app.bsky.actor

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

    val asPersonalDetailsPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsPersonalDetailsPref
    val asAdultContentPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsAdultContentPref
    val asContentLabelPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsContentLabelPref
    val asSavedFeedsPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsSavedFeedsPref
    val asFeedViewPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsFeedViewPref
    val asThreadViewPref get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorDefsThreadViewPref
}
