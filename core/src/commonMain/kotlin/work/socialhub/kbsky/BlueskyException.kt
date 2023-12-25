package work.socialhub.kbsky

class BlueskyException(
    message: String?,
    exception: Exception?,
) : RuntimeException(
    message,
    exception,
) {
    constructor(message: String?) : this(message, null)
    constructor(exception: Exception?) : this(null, exception)
}
