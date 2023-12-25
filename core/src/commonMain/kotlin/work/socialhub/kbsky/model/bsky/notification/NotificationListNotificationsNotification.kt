package work.socialhub.kbsky.model.bsky.notification

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class NotificationListNotificationsNotification {
    var uri: String? = null
    var cid: String? = null
    var author: ActorDefsProfileView? = null

    /**
     * Expected values are 'like', 'repost', 'follow
     * (like, repost, follow, mention, reply, quote)
     */
    var reason: String? = null
    var reasonSubject: String? = null
    var record: RecordUnion? = null
    var isRead: Boolean? = null
    var indexedAt: String? = null
}
