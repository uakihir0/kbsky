package work.socialhub.kbsky.auth

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

    protected var oAuthContext = OAuthContext()
    protected var jwt = JwtStore()

    @BeforeTest
    fun setupTest() {
        try {
            val jsonStr = readFile("../oauth.json")
            oAuthContext = json.decodeFromString<OAuthContext>(jsonStr!!)

        } catch (_: Exception) {
            println("OAuth context not found, so created.")
            oAuthContext = OAuthContext()
        }
    }

    fun auth(): AuthProvider {
        return OAuthProvider(
            accessTokenJwt = jwt.accessJwt!!,
            refreshTokenJwt = jwt.refreshJwt,
            session = oAuthContext
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
     * Save Access JWT
     */
    fun saveJwt() {
        val file = json.encodeToString(jwt)
        saveFile(file, "../jwt.json")
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
