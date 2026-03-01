package work.socialhub.kbsky.auth

import work.socialhub.kbsky.auth.internal.AuthImpl

object AuthFactory {

    fun instance(config: AuthConfig): Auth {
        return AuthImpl(config)
    }

    fun instance(pdsUri: String): Auth {
        return instance(AuthConfig().also {
            it.pdsServer = pdsUri
        })
    }
}