package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsSelfLabels
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedPost : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedPost
    }

    @SerialName("\$type")
    override var type = TYPE

    var text: String? = null
    var langs: List<String>? = null
    var labels: LabelDefsSelfLabels? = null
    var facets: List<RichtextFacet>? = null
    var reply: FeedPostReplyRef? = null
    var embed: EmbedUnion? = null
    var createdAt: String? = null
    var via: String? = null
}
