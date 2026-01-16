package work.socialhub.kbsky.com.atproto.repo

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import kotlin.test.Test
import kotlin.test.assertNotNull

class UploadBlobTest : AbstractTest() {

    @Test
    fun testUploadBlob() = runTest {
        val stream = javaClass.getResourceAsStream("/image/icon.png")
        assertNotNull(stream)

        val response = client()
            .repo()
            .uploadBlob(
                RepoUploadBlobRequest(
                    auth = auth(),
                    name = "icon.png",
                    bytes = stream.readBytes(),
                    contentType = "image/png"
                )
            )

        println(response.data.blob)
    }
}
