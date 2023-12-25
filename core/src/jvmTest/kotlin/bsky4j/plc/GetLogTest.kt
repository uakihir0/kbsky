package kbsky.plc

import kbsky.AbstractTest
import work.socialhub.kbsky.PLCDirectoryFactory
import kotlin.test.Test

class GetLogTest : AbstractTest() {

    @Test
    fun testGetLog() {
        val did = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = PLCDirectoryFactory
            .instance()
            .DIDLogs(did)

        println(checkNotNull(response.data[0].alsoKnownAs)[0])
    }
}
