package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsProfileView(
    var did: String = "",
    var handle: String = "",
    var displayName: String? = null,
    var description: String? = null,
    var avatar: String? = null,
    var associated: ActorDefsProfileAssociated? = null,
    var indexedAt: String? = null,
    var createdAt: String? = null,
    var viewer: ActorDefsViewerState? = null,
    var labels: List<LabelDefsLabel>? = null,
    var verification: ActorDefsVerificationState? = null,
)
