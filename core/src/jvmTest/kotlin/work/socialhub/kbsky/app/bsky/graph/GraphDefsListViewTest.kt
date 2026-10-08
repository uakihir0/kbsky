package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListViewBasic
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GraphDefsListViewTest : AbstractTest() {

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

        val list = json.decodeFromString<GraphDefsListView>(jsonString)
        assertEquals("Community Showcase", list.name)
        assertEquals(21, list.listItemCount)
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

        val list = json.decodeFromString<GraphDefsListViewBasic>(jsonString)
        assertEquals(0, list.listItemCount)
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

        assertNull(json.decodeFromString<GraphDefsListView>(jsonString).listItemCount)
        assertNull(json.decodeFromString<GraphDefsListViewBasic>(jsonString).listItemCount)
    }
}
