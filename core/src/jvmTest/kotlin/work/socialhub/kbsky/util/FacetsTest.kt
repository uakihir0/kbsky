package work.socialhub.kbsky.util

import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetLink
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetMention
import work.socialhub.kbsky.util.facet.FacetList
import work.socialhub.kbsky.util.facet.FacetUtil
import java.nio.charset.StandardCharsets
import kotlin.test.Test

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


    private fun print(records: FacetList) {
        for (record in records.records) {
            println("TYPE: " + record.type)
            println("CTEXT: " + record.contentText)
            println("DTEXT: " + record.displayText)
        }
    }

    private fun print(richTextFacets: List<RichtextFacet>) {
        for (facet in richTextFacets) {
            val index = checkNotNull(facet.index)
            val features = checkNotNull(facet.features)

            println("TYPE: " + facet.type)
            println("START: " + index.byteStart)
            println("END: " + index.byteEnd)

            for (feature in features) {

                println("UNION: " + feature.type)
                if (feature is RichtextFacetLink) {
                    println("LINK: " + feature.uri)
                }
                if (feature is RichtextFacetMention) {
                    println("MENTION: " + feature.did)
                }
            }
        }
    }
}

