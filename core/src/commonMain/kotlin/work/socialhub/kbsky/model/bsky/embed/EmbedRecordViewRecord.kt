package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class EmbedRecordViewRecord : EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewRecord"
    }

    @SerialName("\$type")
    override var type = TYPE

    var uri: String? = null
    var cid: String? = null
    var author: ActorDefsProfileViewBasic? = null
    var value: RecordUnion? = null
    var labels: List<LabelDefsLabel>? = null
    var embeds: List<EmbedViewUnion>? = null
    var indexedAt: String? = null
}
