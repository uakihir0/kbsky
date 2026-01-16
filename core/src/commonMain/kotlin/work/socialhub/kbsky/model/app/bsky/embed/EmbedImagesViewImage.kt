package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedImagesViewImage(
    val thumb: String? = null,
    val fullsize: String? = null,
    val alt: String? = null,
    val aspectRatio: EmbedDefsAspectRatio? = null,
)
