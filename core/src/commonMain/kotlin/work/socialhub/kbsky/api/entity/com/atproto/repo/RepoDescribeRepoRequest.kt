package work.socialhub.kbsky.api.entity.com.atproto.repo

import work.socialhub.kbsky.api.entity.share.MapRequest

class RepoDescribeRepoRequest(
    /** The handle or DID of the repo. */
    val repo: String,
) : MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("repo", repo)
        }
    }
}
