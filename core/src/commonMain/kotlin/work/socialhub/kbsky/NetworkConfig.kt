package work.socialhub.kbsky

open class NetworkConfig {

    /**
     * Skip SSL Validation (Kotlin/JVM Only)
     */
    var skipSSLValidation: Boolean = false

    /**
     * Specifies a request timeout in milliseconds.
     * https://ktor.io/docs/client-timeout.html
     */
    var requestTimeoutMillis: Long? = null

    /**
     * Specifies a connection timeout in milliseconds.
     * https://ktor.io/docs/client-timeout.html
     */
    var connectTimeoutMillis: Long? = null

    /**
     * Specifies a socket timeout (read and write) in milliseconds.
     * https://ktor.io/docs/client-timeout.html
     */
    var socketTimeoutMillis: Long? = null
}