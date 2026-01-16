package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
open class AuthRequest(
    open val auth: AuthProvider
)

