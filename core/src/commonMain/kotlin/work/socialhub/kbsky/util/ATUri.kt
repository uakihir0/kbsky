package work.socialhub.kbsky.util

/**
 * ATProtocol URI
 * at://{did}/{recordType}/{key}
 */
data class ATUri(val did: String, val recordType: String, val rkey: String)