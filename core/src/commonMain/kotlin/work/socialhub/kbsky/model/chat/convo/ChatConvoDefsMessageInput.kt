package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet

@Serializable
class ChatConvoDefsMessageInput {

    lateinit var text: String
    var facets: List<RichtextFacet>? = null
    var embed: EmbedUnion? = null
}
