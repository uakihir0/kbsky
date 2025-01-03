package work.socialhub.kbsky.auth.api

import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.auth.OAuthContext
import work.socialhub.kbsky.auth.api.entity.oauth.BuildAuthorizationUrlRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthAuthorizationCodeTokenRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationResponse
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthRefreshTokenRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthTokenRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthTokenResponse

interface OAuthResource {

    /**
     * Step
     */
    fun pushedAuthorizationRequest(
        context: OAuthContext,
        request: OAuthPushedAuthorizationRequest
    ): Response<OAuthPushedAuthorizationResponse>

    /**
     * Step
     */
    fun buildAuthorizationUrl(
        context: OAuthContext,
        request: BuildAuthorizationUrlRequest
    ): String

    /**
     * Step
     */
    fun tokenRequest(
        context: OAuthContext,
        request: OAuthTokenRequest,
    ): Response<OAuthTokenResponse>


    /**
     * TokenRequest wrapper function for Authorization Code request.
     */
    fun authorizationCodeTokenRequest(
        context: OAuthContext,
        request: OAuthAuthorizationCodeTokenRequest,
    ): Response<OAuthTokenResponse>

    /**
     * TokenRequest wrapper function for Refresh request.
     */
    fun refreshTokenRequest(
        context: OAuthContext,
        request: OAuthRefreshTokenRequest,
    ): Response<OAuthTokenResponse>
}