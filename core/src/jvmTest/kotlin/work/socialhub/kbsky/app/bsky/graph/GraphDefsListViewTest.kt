package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListViewBasic
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Serialization/deserialization tests for listItemCount on
 * app.bsky.graph.defs#listView / #listViewBasic.
 * No network required.
 */
class GraphDefsListViewTest {

    @Test
    fun testListViewListItemCount() {
        val jsonString = """
        {
            "uri": "at://did:plc:example/app.bsky.graph.list/3lexample",
            "cid": "bafyreiexample",
            "name": "Community Showcase",
            "purpose": "app.bsky.graph.defs#curatelist",
            "listItemCount": 21,
            "indexedAt": "2025-08-06T03:43:31.609Z",
            "labels": [],
            "creator": {
                "did": "did:plc:example",
                "handle": "example.bsky.social"
            },
            "description": "desc"
        }
        """.trimIndent()

        val list = fromJson<GraphDefsListView>(jsonString)
        assertEquals("Community Showcase", list.name)
        assertEquals(21, list.listItemCount)
        assertEquals("did:plc:example", list.creator?.did)
        assertEquals("desc", list.description)
        assertEquals("2025-08-06T03:43:31.609Z", list.indexedAt)

        // Round trip: listItemCount is emitted and every mapped field survives.
        assertTrue(toJson(list).contains("\"listItemCount\":21"))
        assertEquals(list, fromJson<GraphDefsListView>(toJson(list)))
    }

    @Test
    fun testListViewBasicListItemCount() {
        val jsonString = """
        {
            "uri": "at://did:plc:example/app.bsky.graph.list/3lexample",
            "cid": "bafyreiexample",
            "name": "Moderation list",
            "purpose": "app.bsky.graph.defs#modlist",
            "listItemCount": 0,
            "indexedAt": "2025-08-06T03:43:31.609Z"
        }
        """.trimIndent()

        val list = fromJson<GraphDefsListViewBasic>(jsonString)
        assertEquals(0, list.listItemCount)

        // Round trip: 0 must not be dropped by serialization.
        assertTrue(toJson(list).contains("\"listItemCount\":0"))
        assertEquals(list, fromJson<GraphDefsListViewBasic>(toJson(list)))
    }

    @Test
    fun testNoListItemCount() {
        val jsonString = """
        {
            "uri": "at://did:plc:example/app.bsky.graph.list/3lexample",
            "cid": "bafyreiexample",
            "name": "Old list",
            "purpose": "app.bsky.graph.defs#curatelist",
            "indexedAt": "2025-08-06T03:43:31.609Z"
        }
        """.trimIndent()

        assertNull(fromJson<GraphDefsListView>(jsonString).listItemCount)
        assertNull(fromJson<GraphDefsListViewBasic>(jsonString).listItemCount)
    }
}
