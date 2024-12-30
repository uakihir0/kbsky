package work.socialhub.kbsky.auth.helper

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.SHA256
import io.ktor.utils.io.core.toByteArray
import kotlinx.datetime.Clock
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import work.socialhub.kbsky.auth.OAuthSession
import work.socialhub.khttpclient.HttpResponse
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.random.Random

@OptIn(ExperimentalEncodingApi::class)
object OAuthHelper {

    fun extractXYFromPublicKey(
        publicKeyBytes: ByteArray
    ): Pair<ByteArray, ByteArray> {

        // Skip the X.509 header part (26 bytes),
        // the rest is the body of the public key
        val xStartIndex = 26 + 1
        val yStartIndex = xStartIndex + 32

        // Extract 32 bytes each of X and Y coordinates
        val x = publicKeyBytes.sliceArray(xStartIndex until xStartIndex + 32)
        val y = publicKeyBytes.sliceArray(yStartIndex until yStartIndex + 32)

        return Pair(byteArrayOf(0) + x, byteArrayOf(0) + y)
    }

    fun makeDPoPHeader(
        clientId: String,
        endpoint: String,
        method: String,
        dPoPNonce: String,
        accessToken: String?,
        authorizationServer: String?,
        // ES256 public key x-value, y-value
        publicKeyWAffineX: ByteArray,
        publicKeyWAffineY: ByteArray,
        // Function to sign a message with a private key
        sign: (String) -> ByteArray
    ): String {

        // Header generation
        val headerJson = buildJsonObject {
            put("alg", "ES256")
            put("typ", "dpop+jwt")
            put("jwk", buildJsonObject {
                put("kty", "EC")
                put("crv", "P-256")
                put("x", Base64.encode(publicKeyWAffineX))
                put("y", Base64.encode(publicKeyWAffineY))
            })
        }

        val epoch = Clock.System.now().epochSeconds

        // Payload generation
        val payloadJson = buildJsonObject {

            // iss, ath are required when requesting PDS
            if (authorizationServer != null && accessToken != null) {
                put("iss", authorizationServer)
                put("ath", hashS256(accessToken))
            } else {
                put("iss", clientId)
            }

            put("sub", clientId)
            put("htu", endpoint)
            put("htm", method)
            put("exp", epoch + 60)
            // random token string (unique per request)
            put("jti", generateRandomValue())
            put("iat", epoch)
            put("nonce", dPoPNonce)
        }

        //We need to remove any padding characters (=) to ensure we are compliant
        //Ideally we'd be using a dedicated JWT library to take care of this for us.
        val headerBase64 = Base64.UrlSafe.encode(headerJson.toString().toByteArray()).replace("=", "");
        val payloadBase64 = Base64.UrlSafe.encode(payloadJson.toString().toByteArray()).replace("=", "");
        val jwtMessage = "$headerBase64.$payloadBase64"

        val jwtSignature = Base64.UrlSafe.encode(sign(jwtMessage)).replace("=", "");
        return "$headerBase64.$payloadBase64.$jwtSignature"
    }

    fun makeClientAssertion(
        keyId: String,
        clientId: String,
        authorizationServer: String,
        // Function to sign a message with a private key
        sign: (String) -> ByteArray
    ): String {

        // Header generation
        val headerJson = buildJsonObject {
            put("typ", "JWT")
            put("alg", "ES256")
            put("kid", keyId)
        }

        val epoch = Clock.System.now().epochSeconds

        // Payload generation
        val payloadJson = buildJsonObject {
            put("iss", clientId)
            put("sub", clientId)
            put("aud", authorizationServer)

            // random token string (unique per request)
            put("jti", generateRandomValue())
            put("iat", epoch)
            put("exp", epoch + 300)
        }

        //We need to remove any padding characters (=) to ensure we are compliant
        //Ideally we'd be using a dedicated JWT library to take care of this for us.
        val headerBase64 = Base64.UrlSafe.encode(headerJson.toString().toByteArray()).replace("=", "");
        val payloadBase64 = Base64.UrlSafe.encode(payloadJson.toString().toByteArray()).replace("=", "");
        val jwtMessage = "$headerBase64.$payloadBase64"

        val jwtSignature = Base64.UrlSafe.encode(sign(jwtMessage)).replace("=", "");
        return "$headerBase64.$payloadBase64.$jwtSignature"
    }

    @OptIn(ExperimentalEncodingApi::class)
    private fun generateRandomValue(): String {
        val randomValueBytes = ByteArray(32)
        Random.nextBytes(randomValueBytes)
        return Base64.encode(randomValueBytes)
    }

    fun HttpResponse.extractDPoPNonce(
        session: OAuthSession
    ): HttpResponse = also {
        headers["dpop-nonce"]?.let {
            session.dPoPNonce = it[0]
        }
    }

    fun hashS256(str: String): String {
        val s256 = CryptographyProvider.Default.get(SHA256).hasher()
        val seed = str.encodeToByteArray()

        return Base64.UrlSafe
            .encode(s256.hashBlocking(seed))
            .replace("=", "")
    }
}