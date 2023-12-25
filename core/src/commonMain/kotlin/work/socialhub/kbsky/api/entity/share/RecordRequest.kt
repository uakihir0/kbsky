package work.socialhub.kbsky.api.entity.share

interface RecordRequest {
    var createdAt: String?

    fun createdAt(): String {
        return createdAt ?: ""
        //_InternalUtility.dateFormat.format(java.util.Date())
    }
}