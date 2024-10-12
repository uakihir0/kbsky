package work.socialhub.kbsky.auth.internal

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.asymmetric.EC
import dev.whyoleg.cryptography.algorithms.asymmetric.ECDSA
import dev.whyoleg.cryptography.algorithms.digest.SHA256
import io.ktor.http.URLBuilder
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.auth.AuthConfig
import work.socialhub.kbsky.auth.OAuthContext
import work.socialhub.kbsky.auth.api.OAuthResource
import work.socialhub.kbsky.auth.api.entity.oauth.BuildAuthorizationUrlRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationResponse
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthTokenRequest
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthTokenResponse
import work.socialhub.kbsky.auth.helper.OAuthHelper
import work.socialhub.kbsky.auth.helper.OAuthHelper.extractDPoPNonce
import work.socialhub.kbsky.auth.helper.RandomHelper
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class _OAuthResource(
    private val config: AuthConfig
) : OAuthResource {

    override fun pushedAuthorizationRequest(
        context: OAuthContext,
        request: OAuthPushedAuthorizationRequest
    ): Response<OAuthPushedAuthorizationResponse> {
        return proceed {
            runBlocking {

                context.clientId?.let { request.clientId = it }
                context.redirectUri?.let { request.redirectUri = it }
                context.state?.let { request.state = it }

                context.codeVerifier?.let { c ->
                    OAuthHelper.hashS256(c).let {
                        request.codeChallenge = it
                    }
                }

                if (request.codeChallenge.isNullOrBlank()) {
                    val codeVerifier = RandomHelper.random(46)
                    context.codeVerifier = codeVerifier
                    OAuthHelper.hashS256(codeVerifier).let {
                        request.codeChallenge = it
                    }
                }

                if (request.state.isNullOrBlank()) {
                    RandomHelper.random(64).let {
                        context.state = it
                        request.state = it
                    }
                }

                HttpRequest()
                    .url(config.pushedAuthorizationRequestEndpoint)
                    .accept(MediaType.JSON)
                    .params(request.toMap())
                    .forceApplicationFormUrlEncoded(true)
                    .post()
                    .extractDPoPNonce(context)
            }
        }
    }

    override fun buildAuthorizationUrl(
        context: OAuthContext,
        request: BuildAuthorizationUrlRequest
    ): String {
        context.clientId?.let { request.clientId = it }

        return URLBuilder(config.authorizationEndpoint).apply {
            this.parameters.append("request_uri", request.requestUri)
            this.parameters.append("client_id", request.clientId)
        }.buildString()
    }

    @OptIn(ExperimentalEncodingApi::class)
    override fun tokenRequest(
        context: OAuthContext,
        request: OAuthTokenRequest
    ): Response<OAuthTokenResponse> {

        return proceed {
            runBlocking {
                context.clientId?.let { request.clientId = it }
                context.redirectUri?.let { request.redirectUri = it }
                context.codeVerifier?.let { request.codeVerifier = it }
                context.dPoPNonce?.let { request.dPoPNonce = it }

                if (context.publicKey == null || context.privateKey == null) {
                    val keyPair = CryptographyProvider.Default.get(ECDSA)
                        .keyPairGenerator(EC.Curve.P256).generateKeyBlocking()

                    context.publicKey = Base64.encode(
                        keyPair.publicKey.encodeToBlocking(EC.PublicKey.Format.DER)
                    )
                    context.privateKey = Base64.encode(
                        keyPair.privateKey.encodeToBlocking(EC.PrivateKey.Format.DER)
                    )
                }

                val publicKeyXY = OAuthHelper.extractXYFromPublicKey(
                    Base64.decode(context.publicKey!!)
                )

                val dPoPHeader = OAuthHelper.makeDPoPHeader(
                    clientId = request.clientId,
                    endpoint = config.tokenEndpoint,
                    method = "POST",
                    dPoPNonce = request.dPoPNonce!!,
                    accessToken = null, // non pds
                    authorizationServer = null, // non pds
                    publicKeyWAffineX = publicKeyXY.first,
                    publicKeyWAffineY = publicKeyXY.second,
                    sign = { jwtMessage ->
                        val privateKey = CryptographyProvider.Default.get(ECDSA)
                            .privateKeyDecoder(EC.Curve.P256)
                            .decodeFromBlocking(
                                EC.PrivateKey.Format.DER,
                                Base64.decode(context.privateKey!!)
                            )

                        privateKey.signatureGenerator(SHA256)
                            .generateSignatureBlocking(jwtMessage.encodeToByteArray())
                    }
                )

                HttpRequest()
                    .url(config.tokenEndpoint)
                    .accept(MediaType.JSON)
                    .params(request.toMap())
                    .forceApplicationFormUrlEncoded(true)
                    .header("DPoP", dPoPHeader)
                    .post()
                    .extractDPoPNonce(context)
            }
        }
    }
}