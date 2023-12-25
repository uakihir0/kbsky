package work.socialhub.kbsky

import work.socialhub.kbsky.api.bsky.*

interface Bluesky : ATProtocol {
    fun actor(): ActorResource
    fun feed(): FeedResource
    fun graph(): GraphResource
    fun notification(): NotificationResource
    fun undoc(): UndocumentedResource
}
