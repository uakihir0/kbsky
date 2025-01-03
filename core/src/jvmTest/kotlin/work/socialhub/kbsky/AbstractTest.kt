package work.socialhub.kbsky

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
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

        // restore session.
        readJwt()
    }

    fun auth(): AuthProvider {
        return BearerTokenAuthProvider(
            accessTokenJwt = jwt.accessJwt!!,
            refreshTokenJwt = jwt.refreshJwt,
        )
    }

    /**
     * Read Access JWT
     */
    private fun readJwt() {
        val file = readFile("../jwt.json")
        if (file != null) {
            val store = json.decodeFromString<JwtStore>(file)
            jwt.accessJwt = store.accessJwt
            jwt.refreshJwt = store.refreshJwt
        }
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
