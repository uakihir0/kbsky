package work.socialhub.kbsky.api.entity.com.atproto.repo


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob
import kotlin.js.JsExport

@Serializable
@JsExport
data class RepoUploadBlobResponse(
    var blob: Blob = Blob(),
)
