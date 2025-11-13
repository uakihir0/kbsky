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
import kotlin.test.Test

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

    protected lateinit var handle: String
    protected lateinit var password: String
    protected var jwt = JwtStore()

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val jsonStr = readFile("../secrets.json")
            val props = json.decodeFromString<Map<String, String>>(jsonStr!!)

            handle = checkNotNull(props["handle"]) { "missing handle." }
            password = checkNotNull(props["password"]) { "missing password." }

        } catch (e: Exception) {
            println(
                """
                !!!
                No credentials exist for testing. 
                Please copy the following file and describe its contents.
                `cp secrets.json.default secrets.json`
                !!!
            """.trimIndent()
            )
            e.printStackTrace()
        }

        //Create session(this is also a test)
        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .server()
            .createSession(
                ServerCreateSessionRequest().also {
                    it.identifier = handle
                    it.password = password
                }
            )

        println(response.data.accessJwt)
        println(response.data.refreshJwt)
        println(response.data.handle)
        println(response.data.did)

        println(response.data.email)
        println(response.data.emailConfirmed)
        println(response.data.didDoc?.asDIDDetails?.id)
        println(response.data.didDoc?.asDIDDetails?.service?.get(0)?.serviceEndpoint)


        // Save the accessJwt for testing other APIs
        jwt.accessJwt = checkNotNull(response.data.accessJwt)
        jwt.refreshJwt = checkNotNull(response.data.refreshJwt)
    }

    fun auth(): AuthProvider {
        return BearerTokenAuthProvider(
            accessTokenJwt = jwt.accessJwt!!,
            refreshTokenJwt = jwt.refreshJwt,
        )
    }

    /**
     * Read File
     */
    private fun readFile(file: String): String? {
        return try {
            File(file).readText()
        } catch (e: Exception) {
            null
        }
    }
}
