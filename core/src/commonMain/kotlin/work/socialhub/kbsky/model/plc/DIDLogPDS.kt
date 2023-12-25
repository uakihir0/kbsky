package work.socialhub.kbsky.model.plc

import kotlinx.serialization.Serializable

@Serializable
class DIDLogPDS {
    var type: String? = null
    var endpoint: String? = null
}
