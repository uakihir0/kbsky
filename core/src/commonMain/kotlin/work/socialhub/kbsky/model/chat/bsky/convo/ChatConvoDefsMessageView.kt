package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class ChatConvoDefsMessageView : ChatConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#messageView"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var id: String
    lateinit var rev: String
    lateinit var text: String
    lateinit var sender: ChatConvoDefsMessageViewSender
    lateinit var sentAt: String

    var facets: List<RichtextFacet>? = null
    var embed: RecordUnion? = null
}
