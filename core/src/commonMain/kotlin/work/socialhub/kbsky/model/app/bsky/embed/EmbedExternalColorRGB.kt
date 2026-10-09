package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * RGB color definition, inspired by site.standard.theme.color#rgb
 * (app.bsky.embed.external#colorRGB)
 */
@Serializable
@JsExport
data class EmbedExternalColorRGB(
    var r: Int = 0,
    var g: Int = 0,
    var b: Int = 0,
)
