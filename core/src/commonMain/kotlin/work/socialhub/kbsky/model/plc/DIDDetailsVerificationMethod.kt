package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
data class DIDDetailsVerificationMethod(
    var id: String? = null,
    var type: String? = null,
    var controller: String? = null,
    var publicKeyMultibase: String? = null,
)
