package work.socialhub.kbsky.model.com.atproto.label


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class LabelDefsLabelValueDefinitionStrings(
    var lang: String = "",
    var name: String = "",
    var description: String = "",
)
