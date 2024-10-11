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

        // http://127.0.0.1/callback?iss=https%3A%2F%2Fbsky.social&state=8760520e052dcca8a0b82845a5a6d945b180f8b570e92acfbc9a5a1446a50007&code=cod-51603e12cc357c05bc164c4f39e8e925e4ccf2efeb82fd2c0962c43298d53879
    }

    @Test
    fun tokenTest() {
        val callback = """
            http://127.0.0.1/callback?iss=https%3A%2F%2Fbsky.social&state=6jd5zg28htpnagluhkjfel9cn59e2mo4scksyweyydjxflknabaxbup5bfnaq48q&code=cod-e04def9c5bb28c2c4443be669827db39ec4d440e9076c0af98b2226969912f0b
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