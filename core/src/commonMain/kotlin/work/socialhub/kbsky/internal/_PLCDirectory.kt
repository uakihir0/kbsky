package work.socialhub.kbsky.internal

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.PLCDirectory
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.model.plc.DIDLog
import work.socialhub.khttpclient.HttpRequest

class _PLCDirectory(
    private val uri: String,
) : PLCDirectory {

    override fun DIDDetails(
        did: String
    ): Response<DIDDetails> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(uri)
                    .path(did)
                    .get()
            }
        }
    }

    override fun DIDLogs(
        did: String
    ): Response<List<DIDLog>> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(uri)
                    .path("$did/log")
                    .get()
            }
        }
    }
}
