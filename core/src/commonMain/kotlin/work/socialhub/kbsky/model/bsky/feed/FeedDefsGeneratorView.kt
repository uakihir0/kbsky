package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet

@Serializable
class FeedDefsGeneratorView : EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedDefs + "#generatorView"
    }

    @SerialName("\$type")
    override var type = TYPE

    var uri: String? = null
    var cid: String? = null
    var did: String? = null
    var creator: ActorDefsProfileView? = null
    var displayName: String? = null
    var description: String? = null
    var descriptionFacets: List<RichtextFacet>? = null
    var avatar: String? = null
    var likeCount: Int? = null
    var viewer: FeedDefsGeneratorViewerState? = null
    var indexedAt: String? = null
}
