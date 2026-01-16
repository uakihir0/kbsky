package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphListItem(
    @SerialName("\$type")
    override var type: String = TYPE,
    var subject: String? = null,
    var list: String? = null,
    var createdAt: String? = null,
) : RecordUnion() {
    companion object {
        const val TYPE = BlueskyTypes.GraphListItem
    }
}
