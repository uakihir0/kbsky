package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * The theme colors of an external source, such as a site.standard.publication.
 * These colors may be used when rendering an embed from that source.
 * (app.bsky.embed.external#viewExternalSourceTheme)
 */
@Serializable
@JsExport
data class EmbedExternalViewExternalSourceTheme(
    var backgroundRGB: EmbedExternalColorRGB? = null,
    var foregroundRGB: EmbedExternalColorRGB? = null,
    var accentRGB: EmbedExternalColorRGB? = null,
    var accentForegroundRGB: EmbedExternalColorRGB? = null,
)
