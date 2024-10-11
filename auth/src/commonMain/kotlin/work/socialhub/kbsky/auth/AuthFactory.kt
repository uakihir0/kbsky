package work.socialhub.kbsky.auth

import work.socialhub.kbsky.auth.internal._Auth

object AuthFactory {

    fun instance(pdsUri: String): Auth {
        return _Auth(AuthConfig().also {
            it.pdsServer = pdsUri
        })
    }
}