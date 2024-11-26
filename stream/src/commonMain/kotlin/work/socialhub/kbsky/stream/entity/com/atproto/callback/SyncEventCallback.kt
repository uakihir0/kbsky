package work.socialhub.kbsky.stream.entity.com.atproto.callback

import work.socialhub.kbsky.model.share.RecordUnion

interface SyncEventCallback {
    fun onEvent(
        cid: String?,
        uri: String?,
        record: RecordUnion
    )
}
