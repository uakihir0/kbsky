package kbsky.plc

import kbsky.AbstractTest
import work.socialhub.kbsky.PLCDirectoryFactory
import kotlin.test.Test

class GetDetailsTest : AbstractTest() {

    @Test
    fun testGetDetails() {
        val did = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = PLCDirectoryFactory
            .instance()
            .DIDDetails(did)

        println(checkNotNull(response.data.alsoKnownAs)[0])
    }
}
