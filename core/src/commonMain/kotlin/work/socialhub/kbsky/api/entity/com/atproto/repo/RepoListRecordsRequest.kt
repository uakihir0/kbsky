package work.socialhub.kbsky.api.entity.com.atproto.repo


import work.socialhub.kbsky.api.entity.share.MapRequest
import kotlin.js.JsExport

@JsExport
data class RepoListRecordsRequest(
    /** The handle or DID of the repo. */
    var repo: String,
    /** The NSID of the record collection. */
    var collection: String

) : MapRequest {

    /** The number of records to return. */
    var limit: Int? = null

    /** rkey cursor. */
    var cursor: String? = null

    /** Reverse the order of the returned records? */
    var reverse: Boolean? = null

    /**
     * (DEPRECATED)
     * The lowest sort-ordered rkey to start from (exclusive)
     */
    var rkeyStart: String? = null

    /**
     * (DEPRECATED)
     * The highest sort-ordered rkey to stop at (exclusive)
     */
    var rkeyEnd: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("repo", repo)
            it.addParam("collection", collection)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
            it.addParam("rkeyStart", rkeyStart)
            it.addParam("rkeyEnd", rkeyEnd)
            it.addParam("reverse", reverse)
        }
    }
}
