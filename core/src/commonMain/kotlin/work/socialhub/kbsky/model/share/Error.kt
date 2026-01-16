package work.socialhub.kbsky.model.share

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class Error(
    var message: String = "",
    var error: String = "",
)
