package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    var did: String = "",
    var handle: String = "",
    var sec: Long = 0,
    var time: String = "",
)
