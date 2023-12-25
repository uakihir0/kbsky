package work.socialhub.kbsky

open class ATProtocolException(
    message: String?,
    exception: Exception?,
) : RuntimeException(
    message,
    exception,
) {
    constructor(message: String?) : this(message, null)
    constructor(exception: Exception?) : this(null, exception)
}
