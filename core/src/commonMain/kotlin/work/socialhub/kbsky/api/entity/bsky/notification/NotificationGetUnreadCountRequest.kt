package work.socialhub.kbsky.api.entity.bsky.notification

import work.socialhub.kbsky.api.entity.share.AuthRequest

class NotificationGetUnreadCountRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt)
