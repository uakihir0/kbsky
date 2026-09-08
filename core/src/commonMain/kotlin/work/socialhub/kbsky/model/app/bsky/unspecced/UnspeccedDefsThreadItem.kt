package work.socialhub.kbsky.model.app.bsky.unspecced


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedDefsThreadItem(
    var uri: String = "",
    var depth: Int = 0,
    var value: UnspeccedDefsThreadItemUnion? = null,
)
