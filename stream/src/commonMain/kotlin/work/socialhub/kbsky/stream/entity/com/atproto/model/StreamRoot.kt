package work.socialhub.kbsky.stream.entity.com.atproto.model

import kotlinx.serialization.Serializable

@Serializable
data class StreamRoot(
    var op: Int? = null,
    var repo: String? = null,
    var ops: List<StreamOp>? = null,
    var t: String? = null,
)

