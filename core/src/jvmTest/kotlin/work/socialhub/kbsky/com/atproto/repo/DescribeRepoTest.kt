package work.socialhub.kbsky.com.atproto.repo

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDescribeRepoRequest
import kotlin.test.Test

class DescribeRepoTest() : AbstractTest() {

    @Test
    fun testDescribeRepo() = runTest {
        val repo = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = client()
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
