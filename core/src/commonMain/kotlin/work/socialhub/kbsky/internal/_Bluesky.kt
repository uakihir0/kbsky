package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.api.bsky.*
import work.socialhub.kbsky.internal.bsky.*

class _Bluesky(uri: String) : _ATProtocol(uri), Bluesky {

    protected val actor: ActorResource = _ActorResource(uri)
    protected val feed: FeedResource = _FeedResource(uri)
    protected val graph: GraphResource = _GraphResource(uri)
    protected val notification: NotificationResource = _NotificationResource(uri)
    protected val undoc: UnspeccedResource = _UnspeccedResource(uri)

    /**
     * {@inheritDoc}
     */
    override fun actor() = actor

    /**
     * {@inheritDoc}
     */
    override fun feed() = feed

    /**
     * {@inheritDoc}
     */
    override fun graph() = graph

    /**
     * {@inheritDoc}
     */
    override fun notification() = notification

    /**
     * {@inheritDoc}
     */
    override fun unspecced() = undoc
}
