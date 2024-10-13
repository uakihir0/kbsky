package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.share.RecordUnion

class RepoCreateRecordRequest(
    auth: AuthProvider,
    /** The handle or DID of the repo. */
    var repo: String,
    /** The NSID of the record collection. */
    var collection: String,
    /** The record to create. */
    var record: RecordUnion
) : AuthRequest(auth), MapRequest {

    /** The key of the record. */
    var rkey: String? = null

    /** Validate the record? */
    var validate: Boolean? = null

    /** Compare and swap with the previous commit by cid. */
    var swapCommit: String? = null

    override fun toMap() =
        mutableMapOf<String, Any>().also {
            it.addParam("repo", repo)
            it.addParam("collection", collection)
            it.addParam("rkey", rkey)
            it.addParam("validate", validate)
            it.addParam("record", record)
            it.addParam("swapCommit", swapCommit)
        }
}