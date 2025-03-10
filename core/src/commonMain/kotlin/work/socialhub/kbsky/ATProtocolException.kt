package work.socialhub.kbsky

import work.socialhub.kbsky.api.entity.share.ErrorResponse

data class ATProtocolException(
    override val message: String?,
    val exception: Exception?,
    val status: Int?,
    val body: String?,
    var response: ErrorResponse? = null,
) : RuntimeException(
    message,
    exception,
) {
    constructor(message: String?) : this(message, null, null, null)
    constructor(exception: Exception?) : this(null, exception, null, null)
}
