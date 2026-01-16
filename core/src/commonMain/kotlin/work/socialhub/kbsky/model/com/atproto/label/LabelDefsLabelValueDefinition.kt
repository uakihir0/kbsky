package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class LabelDefsLabelValueDefinition(
    // The value of the label being defined. Must only include lowercase ascii and the '-' character ([a-z-]+).
    var identifier: String = "",
    // "inform", "alert", "none"
    var severity: String = "",
    // "content", "media", "none"
    var blurs: String = "",
    // "ignore", "warn", "hide"
    var defaultSetting: String = "",
    var adultOnly: Boolean = false,
    var locales: List<LabelDefsLabelValueDefinitionStrings> = emptyList(),
)
