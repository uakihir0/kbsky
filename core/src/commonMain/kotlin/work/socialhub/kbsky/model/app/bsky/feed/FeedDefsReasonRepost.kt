package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic

@Serializable
data class FeedDefsReasonRepost(
    @SerialName("\$type")
    override var type: String = TYPE,
    var by: ActorDefsProfileViewBasic? = null,
    var indexedAt: String? = null,
) : FeedDefsReasonUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#reasonRepost"
    }


}
