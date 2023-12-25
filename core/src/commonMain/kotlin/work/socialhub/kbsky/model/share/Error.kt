package work.socialhub.kbsky.model.share

import kotlinx.serialization.Serializable

@Serializable
class Error {
    lateinit var message: String
    lateinit var error: String
}