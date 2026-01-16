package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Metadata tag on an atproto record, published by the author within the record. Note that schemas should use #selfLabels, not #selfLabel.
 */
@Serializable
@JsExport
data class LabelDefsSelfLabel(
    /** The short string name of the value or type of this label. */
    var `val`: String = "",
)
