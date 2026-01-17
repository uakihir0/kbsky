package work.socialhub.kbsky.model.app.bsky.undoc


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class UndocSearchFeedsUser(
    var did: String? = null,
    var handle: String? = null,
)
