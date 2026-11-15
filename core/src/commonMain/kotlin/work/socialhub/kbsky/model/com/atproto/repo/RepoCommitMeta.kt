package work.socialhub.kbsky.model.com.atproto.repo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * com.atproto.repo.defs#commitMeta
 */
@Serializable
@JsExport
data class RepoCommitMeta(
    var cid: String = "",
    var rev: String = "",
)
