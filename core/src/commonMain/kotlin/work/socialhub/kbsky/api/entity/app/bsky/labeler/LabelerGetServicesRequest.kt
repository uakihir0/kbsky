package work.socialhub.kbsky.api.entity.app.bsky.labeler

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

data class LabelerGetServicesRequest(
    override val auth: AuthProvider,
    var dids: List<String> = emptyList(),
    var detailed: Boolean? = null,
) : AuthRequest(auth)
