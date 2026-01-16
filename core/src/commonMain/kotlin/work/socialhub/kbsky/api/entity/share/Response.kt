package work.socialhub.kbsky.api.entity.share

import kotlin.js.JsExport

/**
 * @author uakihir0
 */
@JsExport
data class Response<T>(
    val data: T,
    val json: String,
)

@JsExport
data class ResponseUnit(
    val json: String,
)
