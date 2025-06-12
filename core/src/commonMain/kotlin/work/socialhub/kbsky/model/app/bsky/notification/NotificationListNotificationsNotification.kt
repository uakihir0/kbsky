package work.socialhub.kbsky.model.app.bsky.notification

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class NotificationListNotificationsNotification(
    var uri: String = "",
    var cid: String = "",
    var author: ActorDefsProfileView = ActorDefsProfileView(),

    /**
     * Expected values are 'like', 'repost', 'follow
     * (like, repost, follow, mention, reply, quote)
     */
    var reason: String = "",
    var reasonSubject: String? = null,

    var record: RecordUnion? = null,
    var isRead: Boolean = false,
    var indexedAt: String = "",

    // TODO: labels
}
