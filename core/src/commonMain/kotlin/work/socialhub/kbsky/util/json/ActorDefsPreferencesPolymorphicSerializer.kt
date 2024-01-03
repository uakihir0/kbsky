package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.actor.*

object ActorDefsPreferencesPolymorphicSerializer :
    JsonContentPolymorphicSerializer<ActorDefsPreferencesUnion>(
        ActorDefsPreferencesUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ActorDefsPreferencesUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            ActorDefsPersonalDetailsPref.TYPE -> ActorDefsPersonalDetailsPref.serializer()
            ActorDefsAdultContentPref.TYPE -> ActorDefsAdultContentPref.serializer()
            ActorDefsContentLabelPref.TYPE -> ActorDefsContentLabelPref.serializer()
            ActorDefsSavedFeedsPref.TYPE -> ActorDefsSavedFeedsPref.serializer()
            ActorDefsFeedViewPref.TYPE -> ActorDefsFeedViewPref.serializer()
            ActorDefsThreadViewPref.TYPE -> ActorDefsThreadViewPref.serializer()
            else -> {
                val type = element.jsonObject["\$type"]?.jsonPrimitive?.content
                println("[Warning] Unknown Item type: $type (ActorDefsPreferencesUnion)")
                return Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ActorDefsPreferencesUnion() {
        override var type: String = "unknown"
    }
}