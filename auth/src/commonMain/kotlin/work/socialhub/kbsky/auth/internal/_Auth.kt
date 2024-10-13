package work.socialhub.kbsky.auth.internal

import work.socialhub.kbsky.auth.Auth
import work.socialhub.kbsky.auth.AuthConfig
import work.socialhub.kbsky.auth.api.OAuthResource
import work.socialhub.kbsky.auth.api.WellKnownResource

class _Auth(
    val config: AuthConfig
) : Auth {

    var wellKnown: WellKnownResource = _WellKnownResource(config)
    var oauth: OAuthResource = _OAuthResource(config)

    override fun wellKnown() = wellKnown
    override fun oauth() = oauth
}