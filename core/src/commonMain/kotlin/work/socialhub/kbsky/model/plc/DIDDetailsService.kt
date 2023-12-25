package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
class DIDDetailsService {
    var id: String? = null
    var type: String? = null
    var serviceEndpoint: String? = null
}
