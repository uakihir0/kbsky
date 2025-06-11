package work.socialhub.kbsky.model.share

import kotlinx.serialization.Serializable

@Serializable
data class Error(
    var message: String = "",
    var error: String = "",
)
