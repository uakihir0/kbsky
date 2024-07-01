package work.socialhub.kbsky.model.chat.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileAssociated
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsViewerState
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel

/**
 * chat.bsky.actor.defs#profileViewBasic
 */
@Serializable
class ActorDefsProfileViewBasic {
    lateinit var did: String
    lateinit var handle: String
    var displayName: String? = null
    var avatar: String? = null
    var associated: ActorDefsProfileAssociated? = null
    var viewer: ActorDefsViewerState? = null
    var labels: List<LabelDefsLabel>? = null
    var chatDisabled: Boolean = false
}
