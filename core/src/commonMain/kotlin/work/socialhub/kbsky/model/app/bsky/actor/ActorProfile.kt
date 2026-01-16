package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorProfile(
    @SerialName("\$type")
    override var type: String = TYPE,
    var displayName: String? = null,
    var description: String? = null,
    var avatar: Blob? = null,
    var banner: Blob? = null,
    var pinnedPost: RepoStrongRef? = null,
) : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorProfile
    }
}
