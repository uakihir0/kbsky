package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.share.RecordUnion

class RepoPutRecordRequest(
    auth: AuthProvider,
    /** The handle or DID of the repo. */
    var repo: String,
    /** The NSID of the record collection. */
    var collection: String,
    /** The key of the record. */
    var rkey: String,
    /** The record to put. */
    var record: RecordUnion
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("repo", repo)
            it.addParam("collection", collection)
            it.addParam("rkey", rkey)
            it.addParam("record", record)
        }
    }
}
