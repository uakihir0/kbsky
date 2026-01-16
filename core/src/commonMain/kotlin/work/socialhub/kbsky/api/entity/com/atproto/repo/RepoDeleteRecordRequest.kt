package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

@JsExport
data class RepoDeleteRecordRequest(
    override val auth: AuthProvider,
    /** The handle or DID of the repo. */
    var repo: String,
    /** The NSID of the record collection. */
    var collection: String,
    /** The key of the record. */
    var rkey: String,
    /** Compare and swap with the previous record by rid. */
    var swapRecord: String? = null,
    /** Compare and swap with the previous commit by cid. */
    var swapCommit: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("repo", repo)
            it.addParam("collection", collection)
            it.addParam("rkey", rkey)
            it.addParam("swapRecord", swapRecord)
            it.addParam("swapCommit", swapCommit)
        }
    }
}
