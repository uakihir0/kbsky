package work.socialhub.kbsky.api.entity.app.bsky.notification

import work.socialhub.kbsky.api.entity.share.AuthRequest

class NotificationGetUnreadCountRequest(
    accessJwt: String
) : AuthRequest(accessJwt)
