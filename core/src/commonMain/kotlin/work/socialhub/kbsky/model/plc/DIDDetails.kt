package work.socialhub.kbsky.model.plc


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class DIDDetails(
    var id: String? = null,
    var alsoKnownAs: List<String>? = null,
    var verificationMethod: List<DIDDetailsVerificationMethod>? = null,
    var service: List<DIDDetailsService>? = null,
) : DidDocUnion() {

    fun pdsEndpoint(): String? {
        return service
            ?.firstOrNull { it.id == "#atproto_pds" }
            ?.serviceEndpoint
    }
}
