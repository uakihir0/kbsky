package work.socialhub.kbsky.plc

import work.socialhub.kbsky.PLCDirectoryFactory
import kotlin.test.Test

class GetDetailsTest() {

    @Test
    fun testGetDetails() {
        val did = "did:plc:bwdof2anluuf5wmfy2upgulw"

        val response = PLCDirectoryFactory
            .instance()
            .DIDDetails(did)

        response.data.service?.forEach {
            println(it.id)
            println(it.type)
            println(it.serviceEndpoint)
        }

        println(checkNotNull(response.data.alsoKnownAs)[0])
    }
}
