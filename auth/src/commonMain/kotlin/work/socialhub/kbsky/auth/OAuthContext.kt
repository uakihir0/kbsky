package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

/**
 * Following values required during OAuth
 */
@Serializable
data class OAuthContext(
    var redirectUri: String? = null,
    var codeVerifier: String? = null,
    var state: String? = null,
) : OAuthSession()

