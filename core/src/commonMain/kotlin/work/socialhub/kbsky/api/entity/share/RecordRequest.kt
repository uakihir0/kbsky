package work.socialhub.kbsky.api.entity.share

import kotlinx.datetime.Clock
import work.socialhub.kbsky.internal.share._InternalUtility

interface RecordRequest {
    var createdAt: String?

    fun createdAt(): String {
        return createdAt ?: _InternalUtility.dateFormat.format(Clock.System.now())
    }
}