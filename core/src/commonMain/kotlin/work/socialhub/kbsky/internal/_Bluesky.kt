package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.api.app.bsky.*
import work.socialhub.kbsky.api.chat.bsky.ConvoResource
import work.socialhub.kbsky.internal.app.bsky.*
import work.socialhub.kbsky.internal.chat.bsky._ConvoResource

class _Bluesky(uri: String) : _ATProtocol(uri), Bluesky {

    protected val actor: ActorResource = _ActorResource(uri)
    protected val feed: FeedResource = _FeedResource(uri)
    protected val graph: GraphResource = _GraphResource(uri)
    protected val notification: NotificationResource = _NotificationResource(uri)
    protected val undoc: UnspeccedResource = _UnspeccedResource(uri)
    protected val convo: ConvoResource = _ConvoResource(uri)

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

    /**
     * {@inheritDoc}
     */
    override fun convo() = convo
}
