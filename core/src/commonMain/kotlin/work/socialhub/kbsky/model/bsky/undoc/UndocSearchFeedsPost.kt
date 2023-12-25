package work.socialhub.kbsky.model.bsky.undoc

import kotlinx.serialization.Serializable

@Serializable
class UndocSearchFeedsPost {
    var createdAt: Long? = null
    var text: String? = null
    var user: String? = null
}
