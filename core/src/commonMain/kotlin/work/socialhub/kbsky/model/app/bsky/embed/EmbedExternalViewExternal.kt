package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedExternalViewExternal(
    var uri: String = "",
    var title: String = "",
    var description: String = "",
    var thumb: String? = null,

    /**
     * When the external content was created, if available.
     * Example: a publication date, for an article.
     */
    var createdAt: String? = null,

    /**
     * When the external content was updated, if available.
     */
    var updatedAt: String? = null,

    /**
     * Estimated reading time in minutes, if applicable and available.
     */
    var readingTime: Int? = null,

    var labels: List<LabelDefsLabel>? = null,

    /**
     * The source of the external content, such as a standard.site publication.
     */
    var source: EmbedExternalViewExternalSource? = null,

    /**
     * StrongRefs (uri+cid) of the Atmosphere records that backed this view.
     */
    var associatedRefs: List<RepoStrongRef>? = null,

    /**
     * Profiles of the owners of the Atmosphere records that backed this view.
     */
    var associatedProfiles: List<ActorDefsProfileViewBasic>? = null,
)
