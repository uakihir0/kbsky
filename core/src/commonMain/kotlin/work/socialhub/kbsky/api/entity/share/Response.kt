package work.socialhub.kbsky.api.entity.share

/**
 * @author uakihir0
 */
data class Response<T>(
    val data: T,
    val json: String
)
