package work.socialhub.kbsky.auth

import io.ktor.http.*
import work.socialhub.kbsky.auth.api.entity.oauth.BuildAuthorizationUrlRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthTokenRequest
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
            {{URI}}
            """
            .trimIndent()

        // val iss = Url(callback).parameters["iss"].also { println(it) }
        // val state = Url(callback).parameters["state"].also { println(it) }
        val code = Url(callback).parameters["code"].also { println(it) }

        val response = AuthFactory
            .instance(BSKY_SOCIAL.uri)
            .oauth()
            .tokenRequest(oAuthContext,
                OAuthTokenRequest().also {
                    it.code = code!!
                }
            )

        println(response.json)
        println(response.data.accessToken)
        println(response.data.refreshToken)

        accessJwt = response.data.accessToken
        saveOAuthContext()
        saveAccessJwt()
    }
}