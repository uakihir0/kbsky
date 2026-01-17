package work.socialhub.kbsky.api.entity.app.bsky.graph


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordResponse
import kotlin.js.JsExport

@Serializable
@JsExport
class GraphFollowResponse : RepoCreateRecordResponse()
