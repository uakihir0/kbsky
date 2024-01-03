package work.socialhub.kbsky.util.json

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object JsonElementUtil {

    fun JsonElement.type(): String? {
        return jsonObject["\$type"]?.jsonPrimitive?.content
    }
}