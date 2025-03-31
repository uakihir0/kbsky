package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.Serializable

/**
 * A text segment. Start is inclusive, end is exclusive. Indices are for utf8-encoded strings.
 */
@Serializable
data class RichtextFacetByteSlice(
    var byteStart: Int? = null,
    var byteEnd: Int? = null
)