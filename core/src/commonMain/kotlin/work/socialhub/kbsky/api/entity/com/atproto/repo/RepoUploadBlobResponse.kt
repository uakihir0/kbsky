package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
data class RepoUploadBlobResponse(
    var blob: Blob = Blob(),
)
