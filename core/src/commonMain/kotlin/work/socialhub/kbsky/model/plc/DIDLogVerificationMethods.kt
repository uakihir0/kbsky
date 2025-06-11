package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
data class DIDLogVerificationMethods(
    var atproto: String? = null,
)
