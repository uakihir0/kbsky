package work.socialhub.kbsky.stream.internal.app.bsky

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.internal.BlueskyImpl
import work.socialhub.kbsky.stream.BlueskyStream
import work.socialhub.kbsky.stream.BlueskyStreamConfig
import work.socialhub.kbsky.stream.api.app.bsky.JetStreamResource

class BlueskyStreamImpl(
    config: BlueskyStreamConfig
) : BlueskyStream {

    protected val bluesky: Bluesky = BlueskyImpl(config)

    protected val jetStream: JetStreamResource = JetStreamResourceImpl(this.bluesky, config)

    /**
     * {@inheritDoc}
     */
    override fun jetStream() = jetStream
}