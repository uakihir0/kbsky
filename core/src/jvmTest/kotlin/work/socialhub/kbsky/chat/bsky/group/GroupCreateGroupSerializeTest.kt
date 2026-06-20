package work.socialhub.kbsky.chat.bsky.group

import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupAddMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateGroupRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRemoveMembersRequest
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * Serialization test for chat.bsky.group POST requests.
 *
 * Verifies that a POST body containing members (an array of dids) is correctly emitted as a JSON array.
 * (Detects the regression where members are dropped if AnySerializer cannot handle a List.)
 * No network required.
 */
class GroupCreateGroupSerializeTest {

    private val auth = BearerTokenAuthProvider("dummy-access-token")

    @Test
    fun testCreateGroupSerialize() {
        val json = GroupCreateGroupRequest(
            auth = auth,
            members = listOf("did:plc:aaa", "did:plc:bbb"),
            name = "My Group",
        ).toMappedJson()

        // members must be emitted as a JSON array (not stringified or dropped).
        assertTrue(json.contains("\"members\""), json)
        assertTrue(json.contains("[\"did:plc:aaa\",\"did:plc:bbb\"]"), json)
        assertTrue(json.contains("\"name\":\"My Group\""), json)
    }

    @Test
    fun testAddMembersSerialize() {
        val json = GroupAddMembersRequest(
            auth = auth,
            convoId = "convo-1",
            members = listOf("did:plc:ccc"),
        ).toMappedJson()

        assertTrue(json.contains("\"convoId\":\"convo-1\""), json)
        assertTrue(json.contains("[\"did:plc:ccc\"]"), json)
    }

    @Test
    fun testRemoveMembersSerialize() {
        val json = GroupRemoveMembersRequest(
            auth = auth,
            convoId = "convo-1",
            members = listOf("did:plc:ccc", "did:plc:ddd"),
        ).toMappedJson()

        assertTrue(json.contains("\"convoId\":\"convo-1\""), json)
        assertTrue(json.contains("[\"did:plc:ccc\",\"did:plc:ddd\"]"), json)
    }
}
