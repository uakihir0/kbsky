package work.socialhub.kbsky.auth

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
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

    protected lateinit var oAuthContext: OAuthContext

    protected lateinit var handle: String
    protected lateinit var password: String
    protected lateinit var accessJwt: String
    protected lateinit var refreshJwt: String

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

        // restore session.
        readAccessJwt()


        try {
            val jsonStr = readFile("../oauth.json")
            oAuthContext = json.decodeFromString<OAuthContext>(jsonStr!!)

        } catch (e: Exception) {
            println("OAuth context not found, so created.")
            oAuthContext = OAuthContext()
        }
    }

    fun auth(): AuthProvider {
        return OAuthProvider(
            accessTokenJwt = accessJwt,
            context = oAuthContext
        )
    }

    fun saveOAuthContext() {
        val json = json.encodeToString(oAuthContext)
        saveFile(json, "../oauth.json")
    }

    fun clearOAuthContext() {
        oAuthContext = OAuthContext()
        saveOAuthContext()
    }

    /**
     * Read Access JWT
     */
    private fun readAccessJwt() {
        val jwt = readFile("../jwt.txt")
        if (jwt != null) {
            accessJwt = jwt
        }
    }

    /**
     * Save Access JWT
     */
    fun saveAccessJwt() {
        saveFile(accessJwt, "../jwt.txt")
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

    /**
     * Save File
     */
    private fun saveFile(str: String?, file: String) {
        try {
            File(file).writeText(str!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
