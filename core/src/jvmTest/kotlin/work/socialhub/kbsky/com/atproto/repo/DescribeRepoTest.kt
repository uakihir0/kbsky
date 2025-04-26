package work.socialhub.kbsky.com.atproto.repo

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDescribeRepoRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class DescribeRepoTest() {

    @Test
    fun testDescribeRepo() {
        val repo = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = ATProtocolFactory
            .instance(BSKY_SOCIAL.uri)
            .repo()
            .describeRepo(
                RepoDescribeRepoRequest(
                    repo = repo
                )
            )

        println(checkNotNull(response.data.handle))

        println(response.data)
    }
}
