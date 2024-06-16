package work.socialhub.kbsky

import work.socialhub.kbsky.api.app.bsky.ActorResource
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.app.bsky.GraphResource
import work.socialhub.kbsky.api.app.bsky.NotificationResource
import work.socialhub.kbsky.api.app.bsky.UnspeccedResource

interface Bluesky : ATProtocol {
    fun actor(): ActorResource
    fun feed(): FeedResource
    fun graph(): GraphResource
    fun notification(): NotificationResource
    fun unspecced(): UnspeccedResource
}
