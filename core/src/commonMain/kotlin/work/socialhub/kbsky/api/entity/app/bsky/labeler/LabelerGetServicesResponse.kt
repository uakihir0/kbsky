package work.socialhub.kbsky.api.entity.app.bsky.labeler

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.labeler.LabelerViewUnion

@Serializable
class LabelerGetServicesResponse {
    lateinit var views: List<LabelerViewUnion>
}
