package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
data class ActorDefsViewerState(
    var muted: Boolean? = null,
    var blockedBy: Boolean? = null,
    /** at-uri  */
    var blocking: String? = null,
    /** at-uri  */
    var following: String? = null,
    /** at-uri  */
    var followedBy: String? = null,
    val knownFollowers: ActorDefsKnownFollowers? = null,
)
