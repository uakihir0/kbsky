package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class ConvoDefsMessageView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var id: String,
    var rev: String,
    var text: String,
    var facets: List<RichtextFacet>? = null,
    var embed: RecordUnion? = null,
    var sender: ConvoDefsMessageViewSender,
    var sentAt: String,
) : ConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#messageView"
    }
}
