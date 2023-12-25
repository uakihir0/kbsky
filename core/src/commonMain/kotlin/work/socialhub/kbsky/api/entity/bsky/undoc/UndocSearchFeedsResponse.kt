package work.socialhub.kbsky.api.entity.bsky.undoc

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.undoc.UndocSearchFeedsPost
import work.socialhub.kbsky.model.bsky.undoc.UndocSearchFeedsUser

@Serializable
class UndocSearchFeedsResponse {
    var cid: String? = null
    var tid: String? = null
    var user: UndocSearchFeedsUser? = null
    var post: UndocSearchFeedsPost? = null
}
