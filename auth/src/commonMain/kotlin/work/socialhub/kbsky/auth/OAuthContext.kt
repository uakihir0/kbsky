package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

/**
 * Following values required during OAuth
 */
@Serializable
class OAuthContext : OAuthSession() {

    var redirectUri: String? = null
    var codeVerifier: String? = null
    var state: String? = null
}

