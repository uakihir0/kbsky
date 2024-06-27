package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel

@Serializable
open class ActorDefsProfileViewDetailed {

    lateinit var did: String
    lateinit var handle: String

    var displayName: String? = null
    var description: String? = null
    var avatar: String? = null
    var banner: String? = null
    var followersCount: Int? = null
    var followsCount: Int? = null
    var postsCount: Int? = null
    var associated: ActorDefsProfileAssociated? = null
    var indexedAt: String? = null
    var viewer: work.socialhub.kbsky.model.app.bsky.actor.ActorDefsViewerState? = null
    var labels: List<LabelDefsLabel>? = null
}
