package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class ConvoDefsMessageView(
    @SerialName("\$type")
    override val type: String = TYPE,
    val id: String,
    val rev: String,
    val text: String,
    val facets: List<RichtextFacet>? = null,
    val embed: RecordUnion? = null,
    val reactions: List<ConvoDefsReactionView> = emptyList(),
    val sender: ConvoDefsMessageViewSender,
    val sentAt: String,
) : ConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#messageView"
    }
}
