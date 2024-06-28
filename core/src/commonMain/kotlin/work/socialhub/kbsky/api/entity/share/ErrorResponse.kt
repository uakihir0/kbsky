package work.socialhub.kbsky.api.entity.share

import kotlinx.serialization.Serializable

@Serializable
class ErrorResponse {
    var message: String = ""
    lateinit var error: String
}