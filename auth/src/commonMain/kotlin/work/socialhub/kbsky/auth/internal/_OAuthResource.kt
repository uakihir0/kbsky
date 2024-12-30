package work.socialhub.kbsky.auth.internal

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.EC
import dev.whyoleg.cryptography.algorithms.ECDSA
import dev.whyoleg.cryptography.algorithms.ECDSA.SignatureFormat
import dev.whyoleg.cryptography.algorithms.SHA256
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
import work.socialhub.kbsky.auth.helper.OAuthHelper.makeClientAssertion
import work.socialhub.kbsky.auth.helper.RandomHelper
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class _OAuthResource(
    private val config: AuthConfig
) : OAuthResource {

    @OptIn(ExperimentalEncodingApi::class)
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

                if (request.keyId?.isNotEmpty() == true) {
                    //Include the necessary fields for confidential clients
                    val clientAssertion = makeClientAssertion(request.keyId!!,
                        context.clientId!!,
                        config.authorizationServer,
                        sign = { jwtMessage ->
                            val privateKey = CryptographyProvider.Default.get(ECDSA)
                                .privateKeyDecoder(EC.Curve.P256)
                                .decodeFromByteArrayBlocking(
                                    EC.PrivateKey.Format.DER,
                                    Base64.decode(context.privateKey!!)
                                )

                            privateKey.signatureGenerator(SHA256, SignatureFormat.RAW)
                                .generateSignatureBlocking(jwtMessage.encodeToByteArray())
                        })
                    request.clientAssertion = clientAssertion;
                }

                HttpRequest()
                    .url(config.pushedAuthorizationRequestEndpoint)
                    .accept(MediaType.JSON)
                    .params(request.toMap())
                    .forceApplicationFormUrlEncoded(true)
                    .postWithRetry(context)
                    //.extractDPoPNonce(context)
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

                if (request.keyId?.isNotEmpty() == true) {
                    //Include the necessary fields for confidential clients
                    val clientAssertion = makeClientAssertion(request.keyId!!,
                        context.clientId!!,
                        config.authorizationServer,
                        sign = { jwtMessage ->
                            val privateKey = CryptographyProvider.Default.get(ECDSA)
                                .privateKeyDecoder(EC.Curve.P256)
                                .decodeFromByteArrayBlocking(
                                    EC.PrivateKey.Format.DER,
                                    Base64.decode(context.privateKey!!)
                                )

                            privateKey.signatureGenerator(SHA256, SignatureFormat.RAW)
                                .generateSignatureBlocking(jwtMessage.encodeToByteArray())
                        })
                    request.clientAssertion = clientAssertion;
                }

                HttpRequest()
                    .url(config.tokenEndpoint)
                    .accept(MediaType.JSON)
                    .params(request.toMap())
                    .forceApplicationFormUrlEncoded(true)
                    .postWithRetry(context)
            }
        }
    }

    @OptIn(ExperimentalEncodingApi::class)
    private fun getDPoPHeader(
        context: OAuthContext,
        endpointURL: String
    ): String {

        if (context.publicKey == null || context.privateKey == null) {
            val keyPair = CryptographyProvider.Default.get(ECDSA)
                .keyPairGenerator(EC.Curve.P256).generateKeyBlocking()

            context.publicKey = Base64.encode(
                keyPair.publicKey.encodeToByteArrayBlocking(EC.PublicKey.Format.DER)
            )
            context.privateKey = Base64.encode(
                keyPair.privateKey.encodeToByteArrayBlocking(EC.PrivateKey.Format.DER)
            )
        }

        val publicKeyXY = OAuthHelper.extractXYFromPublicKey(
            Base64.decode(context.publicKey!!)
        )

        val dPoPHeader = OAuthHelper.makeDPoPHeader(
            clientId = context.clientId!!,
            endpoint = endpointURL,
            method = "POST",
            dPoPNonce = context.dPoPNonce!!,
            accessToken = null, // non pds
            authorizationServer = null, // non pds
            publicKeyWAffineX = publicKeyXY.first,
            publicKeyWAffineY = publicKeyXY.second,
            sign = { jwtMessage ->
                val privateKey = CryptographyProvider.Default.get(ECDSA)
                    .privateKeyDecoder(EC.Curve.P256)
                    .decodeFromByteArrayBlocking(
                        EC.PrivateKey.Format.DER,
                        Base64.decode(context.privateKey!!)
                    )

                privateKey.signatureGenerator(SHA256, SignatureFormat.RAW)
                    .generateSignatureBlocking(jwtMessage.encodeToByteArray())
            }
        )

        return dPoPHeader
    }

    suspend fun HttpRequest.postWithRetry(context: OAuthContext): HttpResponse {

        setDPoPHeader(context)
        val first = this.post();
        if (!isRetryRequired(context, first))
            return first

        //Try again if we have modified the DPoPNonce
        setDPoPHeader(context)
        val second = this.post()
        return second
    }

    private fun HttpRequest.setDPoPHeader(
        context: OAuthContext
    ) {
        val dPoPHeader = getDPoPHeader(context, this.url!!);
        this.header("DPoP", dPoPHeader);
    }

    fun isRetryRequired(
        context: OAuthContext,
        response: HttpResponse
    ): Boolean {
        response.extractDPoPNonce(context)

        // Retry in case of error with DPoP Nonce
        return (response.status / 100 == 4 &&
                response.stringBody.contains("use_dpop_nonce"))
    }
}