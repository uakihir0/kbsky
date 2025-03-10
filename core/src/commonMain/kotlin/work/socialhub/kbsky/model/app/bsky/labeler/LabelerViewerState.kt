package work.socialhub.kbsky.model.app.bsky.labeler

import kotlinx.serialization.Serializable

@Serializable
data class LabelerViewerState(
    var like: String? = null
)
