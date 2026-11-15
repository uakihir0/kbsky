package work.socialhub.kbsky.api.entity.com.atproto.repo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoCommitMeta
import kotlin.js.JsExport

@Serializable
@JsExport
open class RepoApplyWritesResponse {
    var commit: RepoCommitMeta? = null
    var results: List<RepoApplyWritesResult>? = null
}

/**
 * A result of com.atproto.repo.applyWrites.
 * (createResult / updateResult / deleteResult)
 */
@Serializable
@JsExport
open class RepoApplyWritesResult {
    @SerialName("\$type")
    var type: String? = null

    /** Set for createResult / updateResult. */
    var uri: String? = null

    /** Set for createResult / updateResult. */
    var cid: String? = null

    /** "valid" or "unknown". Set for createResult / updateResult. */
    var validationStatus: String? = null

    val isCreateResult get() = type == CREATE_RESULT
    val isUpdateResult get() = type == UPDATE_RESULT
    val isDeleteResult get() = type == DELETE_RESULT

    companion object {
        const val CREATE_RESULT = "com.atproto.repo.applyWrites#createResult"
        const val UPDATE_RESULT = "com.atproto.repo.applyWrites#updateResult"
        const val DELETE_RESULT = "com.atproto.repo.applyWrites#deleteResult"
    }
}
