package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedVideoView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedVideo + "#view"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var cid: String

    // uri
    lateinit var playlist: String

    var thumbnail: String? = null

    var alt: String? = null

    var aspectRatio: EmbedDefsAspectRatio? = null
}
