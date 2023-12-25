package work.socialhub.kbsky.util

/**
 * ATProtocol URI
 * at://{did}/{recordType}/{key}
 */
object ATUriParser {
    /**
     * Parse the URI of the record to get the DID.
     */
    fun getDid(uri: String): String {
        return uri
            .split("://".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[1]
            .split("/".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[0]
    }

    /**
     * Parse the URI of the record to get the RecordType.
     */
    fun getRecordType(uri: String): String {
        return uri.split("://".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[1]
            .split("/".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[1]
    }

    /**
     * Parse the URI of the record to get the rkey.
     */
    fun getRKey(uri: String): String {
        return uri.split("://".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[1]
            .split("/".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray()[2]
    }
}
