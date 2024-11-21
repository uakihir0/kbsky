package work.socialhub.kbsky.api.entity.app.bsky.labeler

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

class LabelerGetServicesRequest(
    auth: AuthProvider
) : AuthRequest(auth) {

    lateinit var dids: List<String>
    var detailed: Boolean? = null
}
