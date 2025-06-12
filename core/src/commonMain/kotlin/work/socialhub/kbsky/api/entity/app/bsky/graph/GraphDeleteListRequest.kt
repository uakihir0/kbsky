package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

data class GraphDeleteListRequest(
    override val auth: AuthProvider,
    val listUri: String,
) : AuthRequest(auth)