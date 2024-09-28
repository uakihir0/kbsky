package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.util.json.PinnedPostSerializer

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
    var viewer: ActorDefsViewerState? = null
    var labels: List<LabelDefsLabel>? = null

    // In Japan, many clients are using "string type declaration" for pinnedPost field,
    // like "pinnedPost": "at://did:plc:xxx".
    // Parse the string type declaration as uri of RepoStrongRef by using [PinnedPostSerializer]
    @Serializable(with = PinnedPostSerializer::class)
    var pinnedPost: RepoStrongRef? = null
}
