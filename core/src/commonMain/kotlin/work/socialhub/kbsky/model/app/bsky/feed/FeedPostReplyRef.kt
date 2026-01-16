package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedPostReplyRef(
    var root: RepoStrongRef? = null,
    var parent: RepoStrongRef? = null,
)
