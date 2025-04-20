package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.auth.AuthProvider

open class AuthRequest(
    open val auth: AuthProvider
)

