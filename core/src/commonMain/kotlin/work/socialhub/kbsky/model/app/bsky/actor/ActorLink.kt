package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsSelfLabels
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

/**
 * A link shown on the account's profile (app.bsky.actor.link).
 * The profile record's links field sets which links are shown, and in what order.
 */
@Serializable
@JsExport
data class ActorLink(
    @SerialName("\$type")
    override var type: String = TYPE,
    /** The link destination, an https URL. */
    var url: String? = null,
    /** Optional label for the link (max 40 graphemes). */
    var title: String? = null,
    /** The destination site's icon (png/jpeg/webp, max 100KB). */
    var icon: Blob? = null,
    var createdAt: String? = null,
    /** Self-label values for this link. */
    var labels: LabelDefsSelfLabels? = null,
) : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorLink
    }
}
