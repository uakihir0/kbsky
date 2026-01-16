package work.socialhub.kbsky.api.entity.app.bsky.graph


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.app.bsky.graph.GraphBlock
import kotlin.js.JsExport

@JsExport
data class GraphBlockRequest(
    override val auth: AuthProvider,
    var subject: String? = null,
    override var createdAt: String? = null,
) : AuthRequest(auth), MapRequest, RecordRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("subject", subject)
            it.addParam("createdAt", createdAt())
        }
    }

    fun toBlock(): GraphBlock {
        val block = GraphBlock()
        block.subject = subject
        block.createdAt = createdAt()
        return block
    }
}
