package work.socialhub.kbsky.auth

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.auth.internal._Auth

object AuthFactory {

    fun instance(uri: String): Auth {
        return _Auth(AuthConfig().also {
            it.pdsServer = uri
        })
    }
}