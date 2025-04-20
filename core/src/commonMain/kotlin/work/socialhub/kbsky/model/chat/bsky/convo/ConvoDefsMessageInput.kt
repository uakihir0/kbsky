package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet

@Serializable
data class ConvoDefsMessageInput(
    var text: String,
    var facets: List<RichtextFacet>? = null,
    var embed: EmbedUnion? = null,
)