package work.socialhub.kbsky.stream.internal.com.atproto

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.internal._ATProtocol
import work.socialhub.kbsky.stream.ATProtocolStream
import work.socialhub.kbsky.stream.ATProtocolStreamConfig
import work.socialhub.kbsky.stream.api.com.atproto.SyncResource

class _ATProtocolStream(
    config: ATProtocolStreamConfig
) : ATProtocolStream {

    protected val atproto: ATProtocol = _ATProtocol(config)

    protected val sync: SyncResource = _SyncResource(this.atproto, config)

    /**
     * {@inheritDoc}
     */
    override fun sync() = sync
}
