package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class RichtextFacet(
    @SerialName("\$type")
    val type: String = BlueskyTypes.RichtextFacet,
    var index: RichtextFacetByteSlice? = null,
    var features: MutableList<RichtextFacetFeatureUnion>? = null,
)
