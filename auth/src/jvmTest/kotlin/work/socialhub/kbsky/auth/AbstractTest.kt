package work.socialhub.kbsky.auth

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import java.io.File
import kotlin.test.BeforeTest

open class AbstractTest {
    protected lateinit var handle: String
    protected lateinit var password: String
    protected lateinit var accessJwt: String
    protected lateinit var refreshJwt: String

    @BeforeTest
    fun setupTest() {
        try {
            // Get account handle and password.
            val json = readFile("../secrets.json")
            val props = fromJson<Map<String, String>>(json!!)

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
    }

    fun getAuthRequest(): AuthRequest {
        return AuthRequest(accessJwt)
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
