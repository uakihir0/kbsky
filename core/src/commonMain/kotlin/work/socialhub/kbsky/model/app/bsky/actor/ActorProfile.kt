package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class ActorProfile : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorProfile
    }

    @SerialName("\$type")
    override var type = TYPE

    var displayName: String? = null
    var description: String? = null
    var avatar: Blob? = null
    var banner: Blob? = null
}
