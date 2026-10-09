package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalView
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import kotlin.js.JsExport

/**
 * The status of the account (e.g. live).
 * (app.bsky.actor.defs#statusView)
 */
@Serializable
@JsExport
data class ActorDefsStatusView(
    var uri: String? = null,
    var cid: String? = null,

    /**
     * The status for the account.
     * Known values: "app.bsky.actor.status#live"
     */
    var status: String = "",

    // "record" (unknown type) is not supported.

    /**
     * An optional embed associated with the status.
     * (union type, but only app.bsky.embed.external#view is defined)
     */
    var embed: EmbedExternalView? = null,

    var labels: List<LabelDefsLabel>? = null,

    /**
     * The date when this status will expire.
     * The application might choose to no longer return the status after expiration.
     */
    var expiresAt: String? = null,

    /**
     * True if the status is not expired, false if it is expired.
     * Only present if expiration was set.
     */
    var isActive: Boolean? = null,

    /**
     * True if the user's go-live access has been disabled by a moderator, false otherwise.
     */
    var isDisabled: Boolean? = null,
) {
    companion object {
        const val STATUS_LIVE = BlueskyTypes.ActorStatus + "#live"
    }
}
