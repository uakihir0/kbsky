package work.socialhub.kbsky.model.app.bsky.labeler


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import kotlin.js.JsExport

@Serializable
@JsExport
data class LabelerView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var cid: String? = null,
    var creator: ActorDefsProfileView? = null,
    var likeCount: Int? = null,
    var viewer: LabelerViewerState? = null,
    var indexedAt: String? = null,
    var labels: List<LabelDefsLabel>? = null,
) : LabelerViewUnion() {
    companion object {
        val TYPE = BlueskyTypes.LabelerDefs + "#labelerView"
    }
}
