package work.socialhub.kbsky.auth

import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.EC
import dev.whyoleg.cryptography.algorithms.ECDSA
import io.ktor.http.Url
import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.auth.helper.OAuthHelper
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.interfaces.ECPublicKey
import java.security.spec.ECGenParameterSpec
import java.security.spec.X509EncodedKeySpec
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.test.Test

@OptIn(ExperimentalEncodingApi::class)
class HelperTest {

    @Test
    fun testGenKey() = runTest {

        println(">> KMP")
        run {
            val keyPair = CryptographyProvider.Default.get(ECDSA)
                .keyPairGenerator(EC.Curve.P256).generateKey()

            var public = Base64.encode(keyPair.publicKey.encodeToByteArray(EC.PublicKey.Format.DER))
            var private = Base64.encode(keyPair.privateKey.encodeToByteArray(EC.PrivateKey.Format.DER))

            println(public)
            println(private)

            Base64.decode(public)
                .let { OAuthHelper.extractXYFromPublicKey(it) }
                .also {
                    println(Base64.encode(it.first))
                    println(Base64.encode(it.second))
                }
        }

        println(">> JVM")
        run {
            val keyPairGenerator = KeyPairGenerator.getInstance("EC")
            keyPairGenerator.initialize(ECGenParameterSpec("secp256r1"))
            val keyPair = keyPairGenerator.generateKeyPair()

            var public = Base64.encode(keyPair.public.encoded)
            var private = Base64.encode(keyPair.private.encoded)

            println(public)
            println(private)

            public.let {
                val keyBytes = Base64.decode(it)
                val keySpec = X509EncodedKeySpec(keyBytes)
                val keyFactory = KeyFactory.getInstance("EC")
                (keyFactory.generatePublic(keySpec) as ECPublicKey).also { k ->
                    println(Base64.encode(k.w.affineX.toByteArray()))
                    println(Base64.encode(k.w.affineY.toByteArray()))
                }
            }
        }
    }

    @Test
    fun testAffineXY() = runTest {
        run {
            val keyPairGenerator = KeyPairGenerator.getInstance("EC")
            keyPairGenerator.initialize(ECGenParameterSpec("secp256r1"))
            val keyPair = keyPairGenerator.generateKeyPair()

            val public = Base64.encode(keyPair.public.encoded)
            val private = Base64.encode(keyPair.private.encoded)

            println(public)
            println(private)

            Base64.decode(public)
                .let { OAuthHelper.extractXYFromPublicKey(it) }
                .also {
                    println(Base64.encode(it.first))
                    println(Base64.encode(it.second))
                }

            public.let {
                val keyBytes = Base64.decode(it)
                val keySpec = X509EncodedKeySpec(keyBytes)
                val keyFactory = KeyFactory.getInstance("EC")
                (keyFactory.generatePublic(keySpec) as ECPublicKey).also { k ->
                    println(Base64.encode(k.w.affineX.toByteArray()))
                    println(Base64.encode(k.w.affineY.toByteArray()))
                }
            }
        }
    }


    @Test
    fun testPath() = runTest {
        val url = Url("https://google.com/aaa/bbb#aaa?p=1")
        println("${url.protocol.name}://${url.host}:${url.port}${url.encodedPath}")
    }
}
