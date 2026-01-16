package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * A text segment. Start is inclusive, end is exclusive. Indices are for utf8-encoded strings.
 */
@Serializable
@JsExport
data class RichtextFacetByteSlice(
    var byteStart: Int? = null,
    var byteEnd: Int? = null
)
