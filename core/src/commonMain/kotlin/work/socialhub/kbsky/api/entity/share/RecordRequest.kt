package work.socialhub.kbsky.api.entity.share

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import work.socialhub.kbsky.internal.share._InternalUtility

interface RecordRequest {
    var createdAt: String?

    @OptIn(ExperimentalTime::class)
    fun createdAt(): String {
        return createdAt ?: _InternalUtility.dateFormat.format(Clock.System.now())
    }
}