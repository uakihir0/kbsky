package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    var did: String = "",
    @SerialName("time_us")
    var timeUs: Long = 0,
    var kind: String = "",
    var commit: Commit? = null,
    var identity: Identity? = null,
    var account: Account? = null,
)
