package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetPreferencesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsAdultContentPref
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsSavedFeedsPref
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsSavedFeedsPrefV2
import kotlin.test.Test

class GetPreferencesTest : AbstractTest() {

    @Test
    fun testGetPreferences() {
        val setting = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .actor()
            .getPreferences(
                ActorGetPreferencesRequest(auth())
            )

        setting.data.preferences.forEach { s ->
            if (s is ActorDefsAdultContentPref) {
                println("> ActorDefsAdultContentPref")
                println("> enabled: ${s.enabled}")
            }

            if (s is ActorDefsSavedFeedsPref) {
                s.saved.forEach { println(it) }
            }

            if (s is ActorDefsSavedFeedsPrefV2) {
                s.items.forEach { println(it) }
            }
        }
    }
}
