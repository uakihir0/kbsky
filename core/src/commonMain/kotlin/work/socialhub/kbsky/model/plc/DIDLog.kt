package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
class DIDLog {
    var sig: String? = null
    var prev: String? = null
    var type: String? = null
    var services: DIDLogService? = null
    var alsoKnownAs: List<String>? = null
    var rotationKeys: List<String>? = null
    var verificationMethods: DIDLogVerificationMethods? = null
}
