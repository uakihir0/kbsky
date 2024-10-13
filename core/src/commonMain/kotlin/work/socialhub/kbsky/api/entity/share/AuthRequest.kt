package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.auth.AuthProvider

open class AuthRequest(
    val auth: AuthProvider
)

