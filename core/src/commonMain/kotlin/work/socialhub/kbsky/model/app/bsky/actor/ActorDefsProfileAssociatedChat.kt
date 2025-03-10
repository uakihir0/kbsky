package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
data class ActorDefsProfileAssociatedChat(
    // "knownValues": ["all", "none", "following"]
    // when nothing is set, it is assumed to be "following"
    var allowIncoming: String
)
