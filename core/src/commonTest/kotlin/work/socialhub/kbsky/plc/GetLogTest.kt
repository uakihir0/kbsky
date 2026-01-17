package work.socialhub.kbsky.plc

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.PLCDirectoryFactory
import kotlin.test.Test

class GetLogTest() {

    @Test
    fun testGetLog() = runTest {
        val did = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = PLCDirectoryFactory
            .instance()
            .DIDLogs(did)

        println(checkNotNull(response.data[0].alsoKnownAs)[0])
    }
}
