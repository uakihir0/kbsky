package work.socialhub.kbsky.model.app.bsky.labeler

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel

@Serializable
class LabelerView : LabelerViewUnion() {

    companion object {
        val TYPE = BlueskyTypes.LabelerDefs + "#labelerView"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var uri: String
    lateinit var cid: String
    lateinit var creator: ActorDefsProfileView
    var likeCount: Int? = null
    var viewer: LabelerViewerState? = null
    var indexedAt: String? = null
    var labels: List<LabelDefsLabel>? = null
}
