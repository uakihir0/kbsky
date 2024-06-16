package work.socialhub.kbsky.model.app.bsky.notification

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class NotificationListNotificationsNotification {
    lateinit var uri: String
    lateinit var cid: String
    lateinit var author: ActorDefsProfileView

    /**
     * Expected values are 'like', 'repost', 'follow
     * (like, repost, follow, mention, reply, quote)
     */
    lateinit var reason: String
    var reasonSubject: String? = null

    lateinit var record: RecordUnion
    var isRead: Boolean = false
    lateinit var indexedAt: String

    // TODO: labels
}
