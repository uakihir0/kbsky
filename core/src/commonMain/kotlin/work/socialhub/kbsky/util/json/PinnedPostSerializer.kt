package work.socialhub.kbsky.util.json

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef

object PinnedPostSerializer :
    JsonTransformingSerializer<RepoStrongRef>(
        RepoStrongRef.serializer()
    ) {

    override fun transformDeserialize(
        element: JsonElement
    ): JsonElement {
        return if (element is JsonObject) {
            element
        } else {
            // fallback for old pinned post format
            JsonObject(mapOf("uri" to element, "cid" to JsonPrimitive("")))
        }
    }
}