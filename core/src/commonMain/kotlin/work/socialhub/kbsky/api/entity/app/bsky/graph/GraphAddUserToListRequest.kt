package work.socialhub.kbsky.api.entity.app.bsky.graph


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem
import kotlin.js.JsExport

@JsExport
data class GraphAddUserToListRequest(
    override val auth: AuthProvider,
    var userDid: String? = null,
    var listUri: String? = null,
    override var createdAt: String? = null,
) : AuthRequest(auth), MapRequest, RecordRequest {

    override fun toMap(): Map<String, Any> {
        return emptyMap()
    }

    fun toListItem(): GraphListItem {
        return GraphListItem().also {
            it.subject = userDid
            it.list = listUri
            it.createdAt = createdAt()
        }
    }
}
