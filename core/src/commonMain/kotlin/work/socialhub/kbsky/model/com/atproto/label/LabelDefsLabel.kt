package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * Metadata tag on an atproto resource (eg, repo or record)
 */
@Serializable
@JsExport
data class LabelDefsLabel(
    /** DID of the actor who created this label */
    var src: String? = null,
    /** AT URI of the record, repository (account), or other resource which this label applies to */
    var uri: String? = null,
    /** optionally, CID specifying the specific version of 'uri' resource this label applies to */
    var cid: String? = null,
    /** the short string name of the value or type of this label */
    var `val`: String? = null,
    /** if true, this is a negation label, overwriting a previous label */
    var neg: Boolean? = null,
    /** timestamp when this label was created */
    var cts: String? = null,
)
