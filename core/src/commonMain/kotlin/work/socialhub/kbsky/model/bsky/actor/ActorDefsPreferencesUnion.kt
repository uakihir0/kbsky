package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName

/**
 * @see ActorDefsAdultContentPref
 * @see ActorDefsContentLabelPref
 * @see ActorDefsSavedFeedsPref
 */
interface ActorDefsPreferencesUnion {
    @SerialName("\$type")
    val type: String
}
