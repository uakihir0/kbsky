package work.socialhub.kbsky.com.atproto.repo

import work.socialhub.kbsky.ATProtocolFactory
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test
import kotlin.test.assertNotNull

class UploadBlobTest : AbstractTest() {

    @Test
    fun testUploadBlob() {
        val stream = javaClass.getResourceAsStream("/image/icon.png")
        assertNotNull(stream)

        val response = ATProtocolFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .repo()
            .uploadBlob(
                RepoUploadBlobRequest(
                    accessJwt = accessJwt,
                    name = "icon.png",
                    bytes = stream.readBytes(),
                )
            )

        println(response.data.blob)
    }
}
