package work.socialhub.kbsky.util

import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetLink
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetMention
import work.socialhub.kbsky.util.facet.FacetList
import work.socialhub.kbsky.util.facet.FacetType
import work.socialhub.kbsky.util.facet.FacetUtil
import java.nio.charset.StandardCharsets
import kotlin.test.Test
import kotlin.test.assertEquals

class FacetsTest {

    @Test
    fun testExtractFacets() {
        val text1 = """
            Wkd Box Office • 09/29-10/01/23 • By Your Paw-ers Combined...A Not So Scary Start to October
            https://www.resetera.com/threads/770129
            """.trimIndent()
        println(text1.toByteArray(StandardCharsets.UTF_8).size)

        val text2 = "Wkd Box Office • 09/29-10/01/23 • By Your Paw-ers Combined...A Not So Scary Start to October\n"
        println(text2.toByteArray(StandardCharsets.UTF_8).size)

        val text3 = """
            Wkd Box Office • 09/29-10/01/23 • By Your Paw-ers Combined...A Not So Scary Start to October
            www.resetera.com/threads/77...
            """.trimIndent()
        println(text3.toByteArray(StandardCharsets.UTF_8).size)


        print(
            FacetUtil
                .extractFacets(text1)
                .richTextFacets(mutableMapOf())
        )
    }

    @Test
    fun testExtractFacets2() {
        val text = "こんにちは https://yahoo.co.jp"

        val facets = FacetUtil.extractFacets(text)
        print(facets)
        print(facets.richTextFacets(mutableMapOf()))

        assertEquals(2, facets.records.size)
        assertEquals("こんにちは ", facets.records[0].contentText)
        assertEquals("こんにちは ", facets.records[0].displayText)
        assertEquals("https://yahoo.co.jp", facets.records[1].contentText)
        assertEquals("yahoo.co.jp", facets.records[1].displayText)
    }

    @Test
    fun testExtractFacets3() {
        val text = "こんにちは https://yahoo.co.jp ほげ"

        val facets = FacetUtil.extractFacets(text)
        print(facets)
        print(facets.richTextFacets(mutableMapOf()))

        assertEquals(3, facets.records.size)
        assertEquals("こんにちは ", facets.records[0].contentText)
        assertEquals("こんにちは ", facets.records[0].displayText)
        assertEquals("https://yahoo.co.jp", facets.records[1].contentText)
        assertEquals("yahoo.co.jp", facets.records[1].displayText)
        assertEquals(" ほげ", facets.records[2].contentText)
        assertEquals(" ほげ", facets.records[2].displayText)
    }

    @Test
    fun testExtractFacets4() {
        val text = "こんにちは https://yahoo.co.jp ほげ https://www.itmedia.co.jp/news/articles/2402/07/news082.html"

        val facets = FacetUtil.extractFacets(text)
        print(facets)
        print(facets.richTextFacets(mutableMapOf()))

        assertEquals(4, facets.records.size)
        assertEquals("こんにちは ", facets.records[0].contentText)
        assertEquals("こんにちは ", facets.records[0].displayText)
        assertEquals("https://yahoo.co.jp", facets.records[1].contentText)
        assertEquals("yahoo.co.jp", facets.records[1].displayText)
        assertEquals(" ほげ ", facets.records[2].contentText)
        assertEquals(" ほげ ", facets.records[2].displayText)
        assertEquals("https://www.itmedia.co.jp/news/articles/2402/07/news082.html", facets.records[3].contentText)
        assertEquals("www.itmedia.co.jp/news/arti...", facets.records[3].displayText)
    }

    @Test
    fun testExtractFacets5() {
        val text = "@takke @zonepane こんにちは https://yahoo.co.jp ほげ"

        val facets = FacetUtil.extractFacets(text)
        print(facets)
        print(facets.richTextFacets(mutableMapOf()))

        assertEquals(6, facets.records.size)
        facets.records[0].let {
            assertEquals(FacetType.Mention, it.type)
            assertEquals("@takke", it.contentText)
            assertEquals("@takke", it.displayText)
        }
        facets.records[1].let {
            assertEquals(FacetType.Text, it.type)
            assertEquals(" ", it.contentText)
            assertEquals(" ", it.displayText)
        }
        facets.records[2].let {
            assertEquals(FacetType.Mention, it.type)
            assertEquals("@zonepane", it.contentText)
            assertEquals("@zonepane", it.displayText)
        }
        facets.records[3].let {
            assertEquals(FacetType.Text, it.type)
            assertEquals(" こんにちは ", it.contentText)
            assertEquals(" こんにちは ", it.displayText)
        }
        facets.records[4].let {
            assertEquals(FacetType.Link, it.type)
            assertEquals("https://yahoo.co.jp", it.contentText)
            assertEquals("yahoo.co.jp", it.displayText)
        }
        facets.records[5].let {
            assertEquals(FacetType.Text, it.type)
            assertEquals(" ほげ", it.contentText)
            assertEquals(" ほげ", it.displayText)
        }
    }

    @Test
    fun testParseMention(){
        val text = "@hello.com @hello-world.com"

        val facets = FacetUtil.extractFacets(text)
        print(facets)
        print(facets.richTextFacets(mutableMapOf()))

        facets.records[0].let {
            assertEquals(FacetType.Mention, it.type)
            assertEquals("@hello.com", it.contentText)
            assertEquals("@hello.com", it.displayText)
        }
        facets.records[1].let {
            assertEquals(FacetType.Text, it.type)
            assertEquals(" ", it.contentText)
            assertEquals(" ", it.displayText)
        }
        facets.records[2].let {
            assertEquals(FacetType.Mention, it.type)
            assertEquals("@hello-world.com", it.contentText)
            assertEquals("@hello-world.com", it.displayText)
        }
    }

    private fun print(records: FacetList) {
        println("facet list: ${records.records.size} ${records.displayText()}")
        for (record in records.records) {
            println("- TYPE: " + record.type)
            println("  CTEXT: " + record.contentText)
            println("  DTEXT: " + record.displayText)
        }
    }

    private fun print(richTextFacets: List<RichtextFacet>) {
        println("richTextFacets: ")
        for (facet in richTextFacets) {
            val index = checkNotNull(facet.index)
            val features = checkNotNull(facet.features)

            println("- TYPE: " + facet.type)
            println("  START: " + index.byteStart)
            println("  END: " + index.byteEnd)

            for (feature in features) {

                println("  - UNION: " + feature.type)
                if (feature is RichtextFacetLink) {
                    println("    LINK: " + feature.uri)
                }
                if (feature is RichtextFacetMention) {
                    println("    MENTION: " + feature.did)
                }
            }
        }
    }
}

