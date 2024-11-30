package work.socialhub.kbsky.stream.entity.com.atproto.model

import kotlinx.serialization.Serializable

@Serializable
class StreamOp {
    var action: String? = null
    var path: String? = null
}