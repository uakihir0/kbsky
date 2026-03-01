package work.socialhub.kbsky.stream.internal.com.atproto

import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.internal.ATProtocolImpl
import work.socialhub.kbsky.stream.ATProtocolStream
import work.socialhub.kbsky.stream.ATProtocolStreamConfig
import work.socialhub.kbsky.stream.api.com.atproto.SyncResource

class ATProtocolStreamImpl(
    config: ATProtocolStreamConfig
) : ATProtocolStream {

    protected val atproto: ATProtocol = ATProtocolImpl(config)

    protected val sync: SyncResource = SyncResourceImpl(this.atproto, config)

    /**
     * {@inheritDoc}
     */
    override fun sync() = sync
}
