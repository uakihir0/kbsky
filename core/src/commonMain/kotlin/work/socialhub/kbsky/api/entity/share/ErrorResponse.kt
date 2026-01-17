package work.socialhub.kbsky.api.entity.share


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ErrorResponse(
    var message: String = "",
    var error: String,
    // for OAuth
    @SerialName("error_description")
    var errorDescription: String = "",
) {

    fun messageForDisplay(): String {
        return if (errorDescription.isNotEmpty()) {
            // OAuth error
            "$error: $errorDescription"
        } else {
            message.ifBlank { error }
        }
    }
}
