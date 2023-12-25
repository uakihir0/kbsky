package work.socialhub.kbsky.model.atproto.repo

import kotlinx.serialization.Serializable

/**
 * A URI with a content-hash fingerprint.
 */
@Serializable
class RepoStrongRef(
    var uri: String,
    var cid: String,
) {

    override fun equals(other: Any?): Boolean {
        val ref = other as RepoStrongRef? ?: return false
        return (ref.uri == uri) && (ref.cid == cid)
    }

    override fun hashCode(): Int {
        var res = 0
        for (v in listOf(uri, cid)) {
            res += v.hashCode()
            res *= 31
        }
        return res
    }
}
