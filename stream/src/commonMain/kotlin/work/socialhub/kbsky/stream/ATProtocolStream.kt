package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.api.atproto.SyncResource

interface ATProtocolStream {
    fun sync(): SyncResource
}
