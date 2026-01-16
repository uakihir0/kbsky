package work.socialhub.kbsky.model.com.atproto.label


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.ATProtocolTypes
import kotlin.js.JsExport

/**
 * Metadata tags on an atproto record, published by the author within the record.
 */
@Serializable
@JsExport
data class LabelDefsSelfLabels(
    @SerialName("\$type")
    var type: String = ATProtocolTypes.LabelDefs + "#selfLabels",
    var values: List<LabelDefsSelfLabel> = emptyList(),
)
