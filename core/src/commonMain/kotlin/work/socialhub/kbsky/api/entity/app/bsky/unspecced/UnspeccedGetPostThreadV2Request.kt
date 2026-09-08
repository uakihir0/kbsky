package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class UnspeccedGetPostThreadV2Request(
    override val auth: AuthProvider,
    var anchor: String = "",
    var above: Boolean? = null,
    var below: Int? = null,
    var branchingFactor: Int? = null,
    var sort: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("anchor", anchor)
            it.addParam("above", above)
            it.addParam("below", below)
            it.addParam("branchingFactor", branchingFactor)
            it.addParam("sort", sort)
        }
    }
}
