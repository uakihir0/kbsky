package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class EmbedVideoView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var cid: String = "",
    // uri
    var playlist: String = "",
    var thumbnail: String? = null,
    var alt: String? = null,
    var aspectRatio: EmbedDefsAspectRatio? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedVideo + "#view"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, "", "", null, null, null)
}
