package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.Serializable

/**
 * A URI with a content-hash fingerprint.
 */
@Serializable
data class RepoStrongRef(
    var uri: String = "",
    var cid: String = "",
)
