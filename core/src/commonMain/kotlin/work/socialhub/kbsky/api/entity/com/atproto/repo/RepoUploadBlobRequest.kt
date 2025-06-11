package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider

data class RepoUploadBlobRequest(
    override val auth: AuthProvider,
    var bytes: ByteArray,
    var name: String = "data",
    var contentType: String = "image/jpeg",
) : AuthRequest(auth)
