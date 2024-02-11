package work.socialhub.kbsky.stream.internal.atproto

import work.socialhub.kbsky.stream.api.atproto.SyncResource
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.internal._ATProtocol
import work.socialhub.kbsky.stream.ATProtocolStream

class _ATProtocolStream(
    apiUri: String,
    streamUri: String,
) : ATProtocolStream {

    protected val atproto: ATProtocol = _ATProtocol(apiUri)

    protected val sync: SyncResource = _SyncResource(this.atproto, streamUri)

    /**
     * {@inheritDoc}
     */
    override fun sync() = sync
}
