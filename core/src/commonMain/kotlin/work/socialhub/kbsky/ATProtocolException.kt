package work.socialhub.kbsky

open class ATProtocolException(
    e: Exception?
) : RuntimeException(e) {
    var error: String? = null
    var errorMessage: String? = null
}
