package work.socialhub.kbsky.api.entity.atproto.server

import work.socialhub.kbsky.api.entity.share.MapRequest

class ServerCreateSessionRequest : MapRequest {

    var identifier: String? = null
    var password: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("identifier", identifier)
            it.addParam("password", password)
        }
    }
}
