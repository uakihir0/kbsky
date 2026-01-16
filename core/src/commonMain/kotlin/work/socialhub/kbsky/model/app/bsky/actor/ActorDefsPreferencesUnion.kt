package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ActorDefsPreferencesPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see ActorDefsPersonalDetailsPref
 * @see ActorDefsAdultContentPref
 * @see ActorDefsContentLabelPref
 * @see ActorDefsSavedFeedsPref
 * @see ActorDefsSavedFeedsPrefV2
 * @see ActorDefsFeedViewPref
 * @see ActorDefsThreadViewPref
 * @see ActorDefsLabelersPref
 */
@Serializable(with = ActorDefsPreferencesPolymorphicSerializer::class)
@JsExport
abstract class ActorDefsPreferencesUnion {
    @SerialName("\$type")
    abstract var type: String

    val asPersonalDetailsPref get() = this as? ActorDefsPersonalDetailsPref
    val asAdultContentPref get() = this as? ActorDefsAdultContentPref
    val asContentLabelPref get() = this as? ActorDefsContentLabelPref
    val asSavedFeedsPref get() = this as? ActorDefsSavedFeedsPref
    val asSavedFeedsPrefV2 get() = this as? ActorDefsSavedFeedsPrefV2
    val asFeedViewPref get() = this as? ActorDefsFeedViewPref
    val asThreadViewPref get() = this as? ActorDefsThreadViewPref
    val asLabelersPref get() = this as? ActorDefsLabelersPref
}
