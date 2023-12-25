package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.atproto.label.LabelDefsLabel

/**
 * A reference to an actor in the network.
 */
@Serializable
class ActorDefsProfileViewBasic {
    lateinit var did: String
    lateinit var handle: String

    var displayName: String? = null
    var avatar: String? = null
    var viewer: ActorDefsViewerState? = null
    var labels: List<LabelDefsLabel>? = null
}
