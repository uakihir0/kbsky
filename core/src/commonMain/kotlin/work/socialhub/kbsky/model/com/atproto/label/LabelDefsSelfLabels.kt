package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.ATProtocolTypes

/**
 * Metadata tags on an atproto record, published by the author within the record.
 */
@Serializable
class LabelDefsSelfLabels {

    @SerialName("\$type")
    var type = ATProtocolTypes.LabelDefs + "#selfLabels"

    lateinit var values: List<LabelDefsSelfLabel>
}
