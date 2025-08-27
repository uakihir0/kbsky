package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.Serializable

/**
 * Repository reference by DID.
 */
@Serializable
data class RepoRef(
    val did: String,
)