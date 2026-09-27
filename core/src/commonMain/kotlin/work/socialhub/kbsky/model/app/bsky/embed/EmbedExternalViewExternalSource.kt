package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * The source of an external embed, such as a standard.site publication.
 * (app.bsky.embed.external#viewExternalSource)
 */
@Serializable
@JsExport
data class EmbedExternalViewExternalSource(
    /**
     * URI of the source, if available.
     * Example: the https:// URL of a site.standard.publication record.
     */
    var uri: String = "",

    /**
     * Fully-qualified URL where an icon representing the source can be fetched.
     * For example, CDN location provided by the App View.
     */
    var icon: String? = null,

    var title: String = "",
    var description: String? = null,
    var theme: EmbedExternalViewExternalSourceTheme? = null,
)
