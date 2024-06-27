package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel

/**
 * A reference to an actor in the network.
 */
@Serializable
class ActorDefsProfileViewBasic {
    lateinit var did: String

    // required but some implementations may not provide it (e.g. post.reply.root.author.handle)
    var handle: String = ""

    var displayName: String? = null
    var avatar: String? = null
<<<<<<< HEAD:core/src/commonMain/kotlin/work/socialhub/kbsky/model/app/bsky/actor/ActorDefsProfileViewBasic.kt
    var viewer: work.socialhub.kbsky.model.app.bsky.actor.ActorDefsViewerState? = null
=======
    var associated: ActorDefsProfileAssociated? = null
    var viewer: ActorDefsViewerState? = null
>>>>>>> main:core/src/commonMain/kotlin/work/socialhub/kbsky/model/bsky/actor/ActorDefsProfileViewBasic.kt
    var labels: List<LabelDefsLabel>? = null
}
