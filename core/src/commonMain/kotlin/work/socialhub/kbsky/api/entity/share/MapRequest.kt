package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.internal.share._InternalUtility

interface MapRequest {

    fun toMappedJson(): String {
        return _InternalUtility.toJson(toMap())
    }

    fun toMap(): Map<String, Any>

    fun MutableMap<String, Any>.addParam(
        key: String,
        value: Any?
    ) {
        if (value == null) {
            return
        }
        if (value is String) {
            if (value.isBlank()) {
                return
            }
        }
        this[key] = value
    }
}
