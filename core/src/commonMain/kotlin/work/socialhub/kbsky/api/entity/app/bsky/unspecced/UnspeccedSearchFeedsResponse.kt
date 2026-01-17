package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.undoc.UndocSearchFeedsPost
import work.socialhub.kbsky.model.app.bsky.undoc.UndocSearchFeedsUser
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedSearchFeedsResponse(
    var cid: String? = null,
    var tid: String? = null,
    var user: UndocSearchFeedsUser? = null,
    var post: UndocSearchFeedsPost? = null,
)
