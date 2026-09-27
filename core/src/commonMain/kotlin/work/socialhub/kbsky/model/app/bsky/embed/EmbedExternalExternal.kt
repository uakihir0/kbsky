package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.share.Blob
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedExternalExternal(
    var uri: String = "",
    var title: String = "",
    var description: String = "",
    var thumb: Blob? = null,

    /**
     * StrongRefs (uri+cid) of the Atmosphere records that backed this external content.
     * (e.g. site.standard.document / site.standard.publication records)
     */
    var associatedRefs: List<RepoStrongRef>? = null,
)
