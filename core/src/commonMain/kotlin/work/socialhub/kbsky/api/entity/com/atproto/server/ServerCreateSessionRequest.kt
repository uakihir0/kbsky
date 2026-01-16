package work.socialhub.kbsky.api.entity.com.atproto.server

import work.socialhub.kbsky.api.entity.share.MapRequest

@JsExport
data class ServerCreateSessionRequest(
    var identifier: String? = null,
    var password: String? = null,
) : MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("identifier", identifier)
            it.addParam("password", password)
        }
    }
}
