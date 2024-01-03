package work.socialhub.kbsky.api.entity.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
class RepoUploadBlobResponse {
    lateinit var blob: Blob
}
