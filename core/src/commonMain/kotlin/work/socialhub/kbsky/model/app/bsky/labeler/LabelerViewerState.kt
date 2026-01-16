package work.socialhub.kbsky.model.app.bsky.labeler

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class LabelerViewerState(
    var like: String? = null,
)
