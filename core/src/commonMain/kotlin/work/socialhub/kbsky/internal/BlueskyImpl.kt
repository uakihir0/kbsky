package work.socialhub.kbsky.internal

import work.socialhub.kbsky.Bluesky
import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.app.bsky.LabelerResource
import work.socialhub.kbsky.api.app.bsky.NotificationResource
import work.socialhub.kbsky.api.app.bsky.UnspeccedResource
import work.socialhub.kbsky.api.app.bsky.VideoResource
import work.socialhub.kbsky.api.chat.bsky.ConvoResource
import work.socialhub.kbsky.internal.app.bsky.ActorResourceImpl
import work.socialhub.kbsky.internal.app.bsky.FeedResourceImpl
import work.socialhub.kbsky.internal.app.bsky.GraphResourceImpl
import work.socialhub.kbsky.internal.app.bsky.LabelerResourceImpl
import work.socialhub.kbsky.internal.app.bsky.NotificationResourceImpl
import work.socialhub.kbsky.internal.app.bsky.UnspeccedResourceImpl
import work.socialhub.kbsky.internal.app.bsky.VideoResourceImpl
import work.socialhub.kbsky.internal.chat.bsky.ConvoResourceImpl

class BlueskyImpl(
    config: BlueskyConfig
) : ATProtocolImpl(config), Bluesky {

    protected val actor: ActorResource = ActorResourceImpl(config)
    protected val feed: FeedResource = FeedResourceImpl(config)
    protected val graph: GraphResource = GraphResourceImpl(config)
    protected val labeler: LabelerResource = LabelerResourceImpl(config)
    protected val notification: NotificationResource = NotificationResourceImpl(config)
    protected val undoc: UnspeccedResource = UnspeccedResourceImpl(config)
    protected val video: VideoResource = VideoResourceImpl(config)
    protected val convo: ConvoResource = ConvoResourceImpl(config)

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
    override fun labeler() = labeler

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
