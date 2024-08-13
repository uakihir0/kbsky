package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
class ActorDefsKnownFollowers {

    val count: Int = 0

    lateinit var followers: List<ActorDefsProfileViewBasic>

}
