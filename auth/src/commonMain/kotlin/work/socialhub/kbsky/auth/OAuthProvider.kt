package work.socialhub.kbsky.auth

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.asymmetric.EC
import dev.whyoleg.cryptography.algorithms.asymmetric.ECDSA
import dev.whyoleg.cryptography.algorithms.digest.SHA256
import io.ktor.http.*
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.auth.helper.OAuthHelper
import work.socialhub.kbsky.auth.helper.OAuthHelper.extractDPoPNonce
import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class OAuthProvider(
    val accessTokenJwt: String,
    val context: OAuthContext,
) : AuthProvider {

    override val did: String
        get() = jwt.sub

    override val pdsDid: String
        get() = jwt.aud

    val jwt: Jwt
        get() {
            val encodedJson = accessTokenJwt
                .split("\\.".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()[1]

            @OptIn(ExperimentalEncodingApi::class)
            val decodedJson = Base64.Default.withPadding(Base64.PaddingOption.PRESENT_OPTIONAL).decode(encodedJson)
            return fromJson<Jwt>(decodedJson.decodeToString())
        }

    @Serializable
    class Jwt {
        lateinit var scope: String
        lateinit var sub: String
        lateinit var aud: String
        lateinit var iss: String
        var iat: Int = -1
        var exp: Int = -1
    }


    @OptIn(ExperimentalEncodingApi::class)
    override fun preProcess(
        method: String,
        request: HttpRequest,
    ) {
        val publicKeyXY = OAuthHelper.extractXYFromPublicKey(
            Base64.decode(context.publicKey!!)
        )

        println("endpoint: " + request.getUrl())
        println("dPoPNonce: " + context.dPoPNonce)

        val dPoPHeader = OAuthHelper.makeDPoPHeader(
            clientId = context.clientId!!,
            endpoint = request.getUrl(),
            method = method,
            dPoPNonce = context.dPoPNonce!!,
            accessToken = accessTokenJwt,
            authorizationServer = jwt.iss,
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

        println(dPoPHeader)
        request.header("Authorization", "DPoP $accessTokenJwt")
        request.header("DPoP", dPoPHeader)
    }


    override fun postProcess(
        method: String,
        request: HttpRequest,
        response: HttpResponse
    ) {
        response.extractDPoPNonce(context)
    }

    fun HttpRequest.getUrl(): String {
        return url?.let {
            Url(it).let { u ->
                "${u.protocol.name}://${u.host}:${u.port}${u.encodedPath}"
            }
        } ?: let {
            val p = if (path!!.startsWith("/")) path else "/${path}"
            port?.let {
                "${schema}://${host}:${port}${p}"
            } ?: let {
                "${schema}://${host}${p}"
            }
        }
    }
}