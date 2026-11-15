package work.socialhub.kbsky.util.json

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import work.socialhub.kbsky.internal.share.InternalUtility
import work.socialhub.kbsky.model.share.RecordUnion

object RecordJsonUtil {

    /**
     * Encode a record into a JsonObject (with `$type`).
     * The result is identical to the `record` field sent by createRecord / putRecord,
     * and can be used as the `value` of applyWrites.
     */
    fun toJsonObject(record: RecordUnion): JsonObject {
        return InternalUtility.json
            .encodeToJsonElement(AnySerializer, record)
            .jsonObject
    }
}
