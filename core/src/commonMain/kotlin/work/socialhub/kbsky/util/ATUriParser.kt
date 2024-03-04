package work.socialhub.kbsky.util

/**
 * ATProtocol URI
 * at://{did}/{recordType}/{key}
 */
object ATUriParser {

    /**
     * Parse the URI of the record.
     */
    fun parse(uri: String): ATUri {
        val array = uri
            .split("://".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[1]
            .split("/".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()

        return ATUri(
            array.getOrNull(0) ?: "",
            array.getOrNull(1) ?: "",
            array.getOrNull(2) ?: ""
        )
    }

    /**
     * Parse the URI of the record to get the DID.
     */
    fun getDid(uri: String): String {
        return parse(uri).did
    }

    /**
     * Parse the URI of the record to get the RecordType.
     */
    fun getRecordType(uri: String): String {
        return parse(uri).recordType
    }

    /**
     * Parse the URI of the record to get the rkey.
     */
    fun getRKey(uri: String): String {
        return parse(uri).rkey
    }
}
