package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
class FeedDefsGeneratorViewerState {
    /** at-url  */
    var like: String? = null
}
