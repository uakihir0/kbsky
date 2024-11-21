package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.labeler.LabelerView
import work.socialhub.kbsky.model.app.bsky.labeler.LabelerViewDetailed
import work.socialhub.kbsky.model.app.bsky.labeler.LabelerViewUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object LabelerViewPolymorphicSerializer :
    JsonContentPolymorphicSerializer<LabelerViewUnion>(
        LabelerViewUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<LabelerViewUnion> {
        return when (val type = element.type()) {
            LabelerView.TYPE -> LabelerView.serializer()
            LabelerViewDetailed.TYPE -> LabelerViewDetailed.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (LabelerViewUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : LabelerViewUnion() {
        override var type: String = "unknown"
    }
}