package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    var active: Boolean = true,
    var did: String = "",
    var sec: Long = 0,
    var time: String = "",
)
