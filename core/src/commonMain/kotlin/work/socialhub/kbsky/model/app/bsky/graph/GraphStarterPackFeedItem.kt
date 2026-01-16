package work.socialhub.kbsky.model.app.bsky.graph


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphStarterPackFeedItem(
    /** at-uri */
    var uri: String
)
