package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsReasonRepost(
    @SerialName("\$type")
    override var type: String = TYPE,
    var by: ActorDefsProfileViewBasic? = null,
    var uri: String? = null,
    var cid: String? = null,
    var indexedAt: String? = null,
) : FeedDefsReasonUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#reasonRepost"
    }


}
