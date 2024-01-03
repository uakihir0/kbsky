package work.socialhub.kbsky.api.entity.bsky.unspecced

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.undoc.UndocSearchFeedsPost
import work.socialhub.kbsky.model.bsky.undoc.UndocSearchFeedsUser

@Serializable
class UnspeccedSearchFeedsResponse {
    var cid: String? = null
    var tid: String? = null
    var user: UndocSearchFeedsUser? = null
    var post: UndocSearchFeedsPost? = null
}
