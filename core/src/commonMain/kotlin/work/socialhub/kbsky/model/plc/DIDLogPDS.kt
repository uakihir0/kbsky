package work.socialhub.kbsky.model.plc


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class DIDLogPDS(
    var type: String? = null,
    var endpoint: String? = null,
)
