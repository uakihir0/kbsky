package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class DIDLogVerificationMethods(
    var atproto: String? = null,
)
