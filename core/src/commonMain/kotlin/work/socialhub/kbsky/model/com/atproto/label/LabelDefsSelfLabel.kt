package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.Serializable

/**
 * Metadata tag on an atproto record, published by the author within the record. Note that schemas should use #selfLabels, not #selfLabel.
 */
@Serializable
class LabelDefsSelfLabel {

    /** The short string name of the value or type of this label. */
    lateinit var `val`: String
}
