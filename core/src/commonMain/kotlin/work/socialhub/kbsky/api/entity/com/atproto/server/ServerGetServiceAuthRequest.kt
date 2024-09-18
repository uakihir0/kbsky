package work.socialhub.kbsky.api.entity.com.atproto.server

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ServerGetServiceAuthRequest(
    accessJwt: String,
    // did
    val aud: String,
    val exp: Long? = null,
    val lxm: String? = null,
) : MapRequest, AuthRequest(accessJwt) {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("aud", aud)
            it.addParam("exp", exp)
            it.addParam("lxm", lxm)
        }
    }
}
