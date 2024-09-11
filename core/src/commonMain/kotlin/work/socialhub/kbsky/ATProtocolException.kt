package work.socialhub.kbsky

import work.socialhub.kbsky.api.entity.share.ErrorResponse

open class ATProtocolException(
    message: String?,
    exception: Exception?,
    val status: Int?,
) : RuntimeException(
    message,
    exception,
) {
    var response: ErrorResponse? = null

    constructor(message: String?) : this(message, null, null)
    constructor(exception: Exception?) : this(null, exception, null)
}
