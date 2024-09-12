package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.app.bsky.NotificationResource
import work.socialhub.kbsky.api.app.bsky.UnspeccedResource
import work.socialhub.kbsky.api.app.bsky.VideoResource
import work.socialhub.kbsky.api.chat.bsky.ConvoResource
import work.socialhub.kbsky.internal.app.bsky._ActorResource
import work.socialhub.kbsky.internal.app.bsky._FeedResource
import work.socialhub.kbsky.internal.app.bsky._GraphResource
import work.socialhub.kbsky.internal.app.bsky._NotificationResource
import work.socialhub.kbsky.internal.app.bsky._UnspeccedResource
import work.socialhub.kbsky.internal.app.bsky._VideoResource
import work.socialhub.kbsky.internal.chat.bsky._ConvoResource

class _Bluesky(
    config: BlueskyConfig
) : _ATProtocol(config), Bluesky {

    protected val actor: ActorResource = _ActorResource(config)
    protected val feed: FeedResource = _FeedResource(config)
    protected val graph: GraphResource = _GraphResource(config)
    protected val notification: NotificationResource = _NotificationResource(config)
    protected val undoc: UnspeccedResource = _UnspeccedResource(config)
    protected val video: VideoResource = _VideoResource(config)
    protected val convo: ConvoResource = _ConvoResource(config)

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
    override fun video() = video

    /**
     * {@inheritDoc}
     */
    override fun convo() = convo
}
