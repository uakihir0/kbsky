package work.socialhub.kbsky.api.entity.share

import kotlinx.serialization.Serializable

@Serializable
class ErrorResponse {
    lateinit var message: String
    lateinit var error: String
}