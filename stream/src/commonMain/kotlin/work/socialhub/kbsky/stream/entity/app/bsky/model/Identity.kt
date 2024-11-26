package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable

@Serializable
class Identity {

    lateinit var did: String
    lateinit var handle: String

    var sec: Long = 0
    lateinit var time: String
}