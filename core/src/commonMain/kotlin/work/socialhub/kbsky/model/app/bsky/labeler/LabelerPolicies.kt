package work.socialhub.kbsky.model.app.bsky.labeler

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabelValueDefinition

@Serializable
data class LabelerPolicies(
    var labelValues: List<String>,
    var labelValueDefinitions: List<LabelDefsLabelValueDefinition> = emptyList()
)
