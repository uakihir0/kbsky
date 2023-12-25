package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
class ActorDefsViewerState {

    var muted: Boolean? = null
    var blockedBy: Boolean? = null

    /** at-uri  */
    var blocking: String? = null

    /** at-uri  */
    var following: String? = null

    /** at-uri  */
    var followedBy: String? = null
}
