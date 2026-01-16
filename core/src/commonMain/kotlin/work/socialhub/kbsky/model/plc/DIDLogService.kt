package work.socialhub.kbsky.model.plc


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class DIDLogService(
    @SerialName("atproto_pds")
    var atprotoPDS: DIDLogPDS? = null,
)
