package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion

@Serializable
class DIDDetails : DidDocUnion() {
    var id: String? = null
    var alsoKnownAs: List<String>? = null
    var verificationMethod: List<DIDDetailsVerificationMethod>? = null
    var service: List<DIDDetailsService>? = null

    fun pdsEndpoint(): String? {
        return service
            ?.firstOrNull { it.id == "#atproto_pds" }
            ?.serviceEndpoint
    }
}
