package work.socialhub.kbsky.stream.internal.app.bsky

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.internal._Bluesky
import work.socialhub.kbsky.stream.BlueskyStream
import work.socialhub.kbsky.stream.BlueskyStreamConfig
import work.socialhub.kbsky.stream.api.app.bsky.JetStreamResource

class _BlueskyStream(
    config: BlueskyStreamConfig
) : BlueskyStream {

    protected val bluesky: Bluesky = _Bluesky(config)

    protected val jetStream: JetStreamResource = _JetStreamResource(this.bluesky, config)

    /**
     * {@inheritDoc}
     */
    override fun jetStream() = jetStream
}