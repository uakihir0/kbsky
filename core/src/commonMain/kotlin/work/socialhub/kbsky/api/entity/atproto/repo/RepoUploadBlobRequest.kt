package work.socialhub.kbsky.api.entity.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest

class RepoUploadBlobRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt) {

    var bytes: ByteArray? = null
    var name: String? = null
}
