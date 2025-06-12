package work.socialhub.kbsky.model.app.bsky.undoc

import kotlinx.serialization.Serializable

@Serializable
data class UndocSearchFeedsUser(
    var did: String? = null,
    var handle: String? = null,
)
