package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic

@Serializable
class FeedDefsReasonRepost : FeedDefsReasonUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#reasonRepost"
    }

    @SerialName("\$type")
    override var type = TYPE

    var by: ActorDefsProfileViewBasic? = null
    var indexedAt: String? = null
}
