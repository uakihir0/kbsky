package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
class ActorDefsSavedFeed(
    val id: String,
    // knownValues: ['feed', 'list', 'timeline']
    val type: String,
    val value: String,
    val pinned: Boolean,
)