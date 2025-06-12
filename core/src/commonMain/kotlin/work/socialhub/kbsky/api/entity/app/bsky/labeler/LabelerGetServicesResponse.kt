package work.socialhub.kbsky.api.entity.app.bsky.labeler

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.labeler.LabelerViewUnion

@Serializable
data class LabelerGetServicesResponse(
    var views: List<LabelerViewUnion> = emptyList(),
)
