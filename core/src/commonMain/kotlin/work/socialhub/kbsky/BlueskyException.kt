package work.socialhub.kbsky

data class BlueskyException(
    override val message: String?,
    val exception: Exception?,
) : RuntimeException(
    message,
    exception,
) {
    constructor(message: String?) : this(message, null)
    constructor(exception: Exception?) : this(null, exception)
}
