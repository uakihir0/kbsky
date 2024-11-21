package work.socialhub.kbsky.model.com.atproto.label

import kotlinx.serialization.Serializable

@Serializable
class LabelDefsLabelValueDefinition {

    // The value of the label being defined. Must only include lowercase ascii and the '-' character ([a-z-]+).
    lateinit var identifier: String

    // "inform", "alert", "none"
    lateinit var severity: String

    // "content", "media", "none"
    lateinit var blurs: String

    // "ignore", "warn", "hide"
    var defaultSetting: String = ""

    var adultOnly: Boolean = false

    lateinit var locales: List<LabelDefsLabelValueDefinitionStrings>
}
