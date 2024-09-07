package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.Blob

/**
 * A video embedded in a Bluesky record
 */
@Serializable
class EmbedVideo : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedVideo
    }

    @SerialName("\$type")
    override var type = TYPE

    var video: Blob? = null

    // TODO Add support for captions
//    var captions: List<EmbedVideoCaption>? = null

    var alt: String? = null

    var aspectRatio: EmbedDefsAspectRatio? = null
}
