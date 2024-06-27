package work.socialhub.kbsky.model.chat.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileAssociated
import work.socialhub.kbsky.model.bsky.actor.ActorDefsViewerState

/**
 * chat.bsky.actor.defs#profileViewBasic
 */
@Serializable
class ChatActorDefsProfileViewBasic {
    lateinit var did: String
    lateinit var handle: String
    var displayName: String? = null
    var avatar: String? = null
    var associated: ActorDefsProfileAssociated? = null
    var viewer: ActorDefsViewerState? = null
    var labels: List<LabelDefsLabel>? = null
    var chatDisabled: Boolean = false
}
