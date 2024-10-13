package work.socialhub.kbsky.api.entity.com.atproto.server

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class ServerGetServiceAuthRequest(
    auth: AuthProvider,
    // did
    val aud: String,
    val exp: Long? = null,
    val lxm: String? = null,
) : MapRequest, AuthRequest(auth) {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("aud", aud)
            it.addParam("exp", exp)
            it.addParam("lxm", lxm)
        }
    }
}
