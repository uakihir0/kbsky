package work.socialhub.kbsky.auth.internal

import work.socialhub.kbsky.auth.Auth
import work.socialhub.kbsky.auth.AuthConfig
import work.socialhub.kbsky.auth.api.OAuthResource
import work.socialhub.kbsky.auth.api.WellKnownResource

class AuthImpl(
    val config: AuthConfig
) : Auth {

    var wellKnown: WellKnownResource = WellKnownResourceImpl(config)
    var oauth: OAuthResource = OAuthResourceImpl(config)

    override fun wellKnown() = wellKnown
    override fun oauth() = oauth
}