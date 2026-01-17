package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedRecordViewRecord(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var cid: String? = null,
    var author: ActorDefsProfileViewBasic? = null,
    var value: RecordUnion? = null,
    var labels: List<LabelDefsLabel>? = null,
    var embeds: List<EmbedViewUnion>? = null,
    var indexedAt: String? = null,
) : EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewRecord"
    }
}
