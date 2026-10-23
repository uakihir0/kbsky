package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import kotlin.js.JsExport

/**
 * A link shown on the account's profile.
 * (app.bsky.actor.defs#profileLinkView)
 */
@Serializable
@JsExport
data class ActorDefsProfileLinkView(
    /**
     * The app.bsky.actor.link record, e.g. for reporting the link.
     */
    var uri: String = "",
    var cid: String = "",

    /**
     * The link destination.
     */
    var url: String = "",

    var title: String? = null,

    /**
     * Image URL for the destination site's icon.
     */
    var icon: String? = null,

    var labels: List<LabelDefsLabel>? = null,
)
