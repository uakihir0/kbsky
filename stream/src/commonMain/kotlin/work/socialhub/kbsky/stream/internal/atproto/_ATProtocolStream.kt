package work.socialhub.kbsky.stream.internal.atproto

import kbsky.stream.api.atproto.SyncResource
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.internal._ATProtocol
import work.socialhub.kbsky.stream.ATProtocolStream

class _ATProtocolStream(
    uri: String
) : ATProtocolStream {

    protected val atproto: ATProtocol = _ATProtocol(uri)

    protected val sync: SyncResource = _SyncResource(this.atproto, uri)

    /**
     * {@inheritDoc}
     */
    override fun sync() = sync
}
