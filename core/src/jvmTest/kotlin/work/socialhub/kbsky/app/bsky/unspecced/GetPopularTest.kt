package work.socialhub.kbsky.app.bsky.unspecced

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularRequest
import kotlin.test.Test

class GetPopularTest : AbstractTest() {

    @Test
    fun testGetPopular() = runTest {
        val feeds = client()
            .unspecced()
            .getPopular(
                UnspeccedGetPopularRequest(auth())
            )

        feeds.data.feed.forEach {
            print(it.post)
        }
    }
}
