package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
class DIDDetails {
    var id: String? = null
    var alsoKnownAs: List<String>? = null
    var verificationMethod: List<DIDDetailsVerificationMethod>? = null
    var service: List<DIDDetailsService>? = null
}
