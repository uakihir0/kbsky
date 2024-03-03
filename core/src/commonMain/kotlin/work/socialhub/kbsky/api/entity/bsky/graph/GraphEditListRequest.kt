package work.socialhub.kbsky.api.entity.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest

class GraphEditListRequest(
    accessJwt: String,
    val listUri: String,
    val name: String,
    val description: String?,
) : AuthRequest(accessJwt)