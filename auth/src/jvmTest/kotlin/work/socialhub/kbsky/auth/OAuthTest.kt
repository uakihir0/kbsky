package work.socialhub.kbsky.auth

import io.ktor.http.Url
import work.socialhub.kbsky.auth.api.entity.oauth.BuildAuthorizationUrlRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthAuthorizationCodeTokenRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthRefreshTokenRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class OAuthTest : AbstractTest() {

    @Test
    fun parTest() {

        clearOAuthContext()
        val context = oAuthContext.also {
            it.clientId = "https://www.uakihir0.com/socialhub/oauth/client-metadata.json"
            it.redirectUri = "http://127.0.0.1/callback"
        }

        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .oauth()
            .pushedAuthorizationRequest(context,
                OAuthPushedAuthorizationRequest().also {
                    it.loginHint = "uakihir0.com"
                }
            )

        println(response.data.requestUri)

        val authorizeUrl = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .oauth().buildAuthorizationUrl(context,
                BuildAuthorizationUrlRequest().also {
                    it.requestUri = response.data.requestUri
                })

        println(authorizeUrl)
        saveOAuthContext()
    }

    @Test
    fun tokenTest() {
        val callback = """
            http://127.0.0.1/callback?iss=https%3A%2F%2Fbsky.social&state=7px3ldl0huvljddfqur00607mb57x9e55siwcpz3m00lrsx5i06geoyc65g06lmz&code=cod-bca898cc79bd729964492d72c356b37d1ed63561f23c67096844205d6ae56555
            """
            .trimIndent()

        // val iss = Url(callback).parameters["iss"].also { println(it) }
        // val state = Url(callback).parameters["state"].also { println(it) }
        val code = Url(callback).parameters["code"].also { println(it) }

        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .oauth()
            .authorizationCodeTokenRequest(oAuthContext,
                OAuthAuthorizationCodeTokenRequest().also {
                    it.code = code!!
                }
            )

        println(response.json)
        println(response.data.accessToken)
        println(response.data.refreshToken)

        jwt.accessJwt = response.data.accessToken
        jwt.refreshJwt = response.data.refreshToken
        saveOAuthContext()
        saveJwt()
    }

    @Test
    fun refreshToken() {
        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .oauth()
            .refreshTokenRequest(oAuthContext,
                OAuthRefreshTokenRequest(auth())
            )

        println(response.json)
        println(response.data.accessToken)
        println(response.data.refreshToken)

        jwt.accessJwt = response.data.accessToken
        jwt.refreshJwt = response.data.refreshToken
        saveOAuthContext()
        saveJwt()
    }
}