package work.socialhub.kbsky.bsky.actor

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.actor.ActorGetPreferencesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.bsky.actor.ActorDefsSavedFeedsPref
import kotlin.test.Test

class GetPreferencesTest : AbstractTest() {

    @Test
    fun testGetPreferences() {
        val setting = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .actor()
            .getPreferences(
                ActorGetPreferencesRequest(accessJwt)
            )

        setting.data.preferences?.forEach { s ->
            if (s is ActorDefsSavedFeedsPref) {
                s.saved?.forEach { println(it) }
            }
        }
    }
}
