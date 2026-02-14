package work.socialhub.kbsky

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.util.json.AnySerializer
import java.io.File
import kotlin.test.BeforeTest

open class AbstractTest {

    protected val json = Json {
        prettyPrint = true
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        serializersModule = SerializersModule {
            contextual(Any::class, AnySerializer)
        }
    }

    protected var handle: String? = null
    protected var password: String? = null
    protected var jwt = JwtStore()

    @BeforeTest
    fun setupTest() {

        try {
            // Get account from environment variable.
            handle = System.getenv("ATP_HANDLE")
                ?: System.getProperty("ATP_HANDLE")
            password = System.getenv("ATP_PASSWORD")
                ?: System.getProperty("ATP_PASSWORD")
        } catch (_: Exception) {
        }

        if (handle == null || password == null) {
            try {
                // Get account handle and password.
                readTestProps()?.get("bluesky")?.let {
                    handle = checkNotNull(it["ATP_HANDLE"])
                    password = checkNotNull(it["ATP_PASSWORD"])
                }
            } catch (_: Exception) {
            }
        }

        if (handle == null || password == null) {
            throw IllegalStateException(
                """!!!
                No credentials exist for testing. 
                Set the environment variable ATP_HANDLE and ATP_PASSWORD
                or copy the following file and describe its contents.
                `cp secrets.json.default secrets.json`
                !!!""".trimIndent()
            )
        }

        val response = ATProtocolFactory
            .instance(
                ATProtocolConfig().also {
                    it.pdsUri = BSKY_SOCIAL.uri
                    it.skipSSLValidation = true
                },
            )
            .server()
            .createSessionBlocking(
                ServerCreateSessionRequest().also {
                    it.identifier = handle
                    it.password = password
                }
            )

        // Save the accessJwt for testing other APIs
        jwt.accessJwt = checkNotNull(response.data.accessJwt)
        jwt.refreshJwt = checkNotNull(response.data.refreshJwt)
    }

    fun client(): Bluesky {
        return BlueskyFactory
            .instance(
                config = BlueskyConfig().also {
                    it.pdsUri = BSKY_SOCIAL.uri
                    it.skipSSLValidation = true
                }
            )
    }

    fun auth(): AuthProvider {
        return BearerTokenAuthProvider(
            accessTokenJwt = jwt.accessJwt!!,
            refreshTokenJwt = jwt.refreshJwt,
        )
    }

    /**
     * Read Test Properties
     */
    private fun readTestProps(): Map<String, Map<String, String>>? {
        return try {
            val jsonStr = File("../secrets.json").readText()
            json.decodeFromString<Map<String, Map<String, String>>>(jsonStr)
        } catch (e: Exception) {
            null
        }
    }
}
