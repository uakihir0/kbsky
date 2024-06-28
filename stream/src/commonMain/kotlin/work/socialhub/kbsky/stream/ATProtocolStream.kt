package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.api.com.atproto.SyncResource

interface ATProtocolStream {
    fun sync(): SyncResource
}
