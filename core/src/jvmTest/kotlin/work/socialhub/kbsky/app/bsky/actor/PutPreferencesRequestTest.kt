package work.socialhub.kbsky.app.bsky.actor

import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorPutPreferencesRequest
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.json
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Tests that putPreferences sends the given raw preferences as they are.
 * No network required.
 */
class PutPreferencesRequestTest {

    private val auth = BearerTokenAuthProvider("dummy")

    @Test
    fun testBodyKeepsRawPreferences() {
        val preferences = json.parseToJsonElement(
            """
            [
                {"${'$'}type": "app.bsky.actor.defs#adultContentPref", "enabled": false},
                {
                    "${'$'}type": "app.bsky.actor.defs#savedFeedsPrefV2",
                    "items": [
                        {"id": "3l6oveex3ii2l", "type": "timeline", "value": "following", "pinned": true}
                    ]
                },
                {"${'$'}type": "app.bsky.actor.defs#somethingNewPref", "unknownField": {"nested": [1, 2, 3]}}
            ]
            """.trimIndent()
        ).jsonArray

        val body = ActorPutPreferencesRequest(
            auth = auth,
            preferences = preferences,
        ).toJson()

        val parsed = json.parseToJsonElement(body).jsonObject
        assertEquals(setOf("preferences"), parsed.keys)
        // unknown preference types and fields must be sent untouched, in the same order
        assertEquals(preferences, parsed["preferences"]?.jsonArray)
    }

    @Test
    fun testBodyWithEmptyPreferences() {
        val body = ActorPutPreferencesRequest(
            auth = auth,
            preferences = emptyList(),
        ).toJson()

        assertEquals("""{"preferences":[]}""", body)
    }
}
