package work.socialhub.kbsky.api.entity.share


import work.socialhub.kbsky.internal.share._InternalUtility
import kotlin.js.JsExport
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@JsExport
interface RecordRequest {
    var createdAt: String?

    @OptIn(ExperimentalTime::class)
    @JsExport.Ignore

    fun createdAt(): String {
        return createdAt ?: _InternalUtility.dateFormat.format(Clock.System.now())
    }
}
