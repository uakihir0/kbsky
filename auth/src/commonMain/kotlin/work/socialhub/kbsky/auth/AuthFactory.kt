package work.socialhub.kbsky.auth

import work.socialhub.kbsky.auth.internal._Auth

object AuthFactory {

    fun instance(config: AuthConfig): Auth {
        return _Auth(config)
    }

    fun instance(pdsUri: String): Auth {
        return instance(AuthConfig().also {
            it.pdsServer = pdsUri
        })
    }
}