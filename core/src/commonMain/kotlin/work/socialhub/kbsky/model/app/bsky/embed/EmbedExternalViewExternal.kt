package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.Serializable

@Serializable
class EmbedExternalViewExternal {

    lateinit var uri: String
    lateinit var title: String
    lateinit var description: String
    var thumb: String? = null
}
