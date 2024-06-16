package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.app.bsky.NotificationResource
import work.socialhub.kbsky.api.app.bsky.UnspeccedResource
import work.socialhub.kbsky.internal.app.bsky._ActorResource
import work.socialhub.kbsky.internal.app.bsky._FeedResource
import work.socialhub.kbsky.internal.app.bsky._GraphResource
import work.socialhub.kbsky.internal.app.bsky._NotificationResource
import work.socialhub.kbsky.internal.app.bsky._UnspeccedResource

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
