package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
data class ActorDefsKnownFollowers(
    val count: Int = 0,
    var followers: List<ActorDefsProfileViewBasic> = emptyList(),
)
