package work.socialhub.kbsky.stream.util.callback

import work.socialhub.kbsky.model.share.RecordUnion

interface EventCallback {
    fun onEvent(
        cid: String?,
        uri: String?,
        record: RecordUnion
    )
}
