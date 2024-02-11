package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
class EmbedExternalExternal {
    lateinit var uri: String
    lateinit var title: String
    lateinit var description: String
    var thumb: Blob? = null
}
