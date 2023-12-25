package work.socialhub.kbsky.model.bsky.undoc

import kotlinx.serialization.Serializable

@Serializable
class UndocSearchFeedsUser {
    var did: String? = null
    var handle: String? = null
}
