package work.socialhub.kbsky

import work.socialhub.kbsky.api.app.bsky.*
import work.socialhub.kbsky.api.chat.bsky.ConvoResource

interface Bluesky : ATProtocol {
    fun actor(): ActorResource
    fun feed(): FeedResource
    fun graph(): GraphResource
    fun notification(): NotificationResource
    fun unspecced(): UnspeccedResource
    fun convo(): ConvoResource
}
