package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

class GraphDeleteListRequest(
    auth: AuthProvider,
    val listUri: String,
) : AuthRequest(auth)