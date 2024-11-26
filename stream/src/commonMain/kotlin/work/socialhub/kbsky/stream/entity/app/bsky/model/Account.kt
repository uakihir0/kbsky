package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable

@Serializable
class Account {
    var active: Boolean = true
    lateinit var did: String

    var sec: Long = 0
    lateinit var time: String
}