package work.socialhub.kbsky.auth.api

import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.auth.AbstractTest
import work.socialhub.kbsky.domain.Service.OYSTER_US_EAST
import kotlin.test.Test

class PostTest : AbstractTest() {

    @Test
    fun testPost() {
        try {
            val response = BlueskyFactory
                .instance(OYSTER_US_EAST.uri)
                .feed()
                .post(
                    FeedPostRequest(auth()).also {
                        it.text = "テスト投稿"
                    }
                )

            println(response.data.uri)
        } finally {
            println(oAuthContext.dPoPNonce)
            saveOAuthContext()
        }
    }
}