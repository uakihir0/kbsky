package work.socialhub.kbsky.model.app.bsky.labeler


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabelValueDefinition
import kotlin.js.JsExport

@Serializable
@JsExport
data class LabelerPolicies(
    var labelValues: List<String> = emptyList(),
    var labelValueDefinitions: List<LabelDefsLabelValueDefinition> = emptyList(),
)
