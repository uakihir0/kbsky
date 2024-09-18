package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.AuthRequest

class RepoUploadBlobRequest(
    accessJwt: String,
    var bytes: ByteArray,
    var name: String = "data",
    var contentType: String = "image/jpeg",
) : AuthRequest(accessJwt)
