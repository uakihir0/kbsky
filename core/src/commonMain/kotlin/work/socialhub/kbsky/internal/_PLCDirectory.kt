package work.socialhub.kbsky.internal

import work.socialhub.kbsky.PLCDirectory
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.model.plc.DIDDetails
import work.socialhub.kbsky.model.plc.DIDLog
import work.socialhub.kbsky.util.toBlocking
import work.socialhub.khttpclient.HttpRequest

class _PLCDirectory(
    private val uri: String,
) : PLCDirectory {

    override suspend fun DIDDetails(
        did: String
    ): Response<DIDDetails> {

        return proceed {
            HttpRequest()
                .url("$uri$did")
                .get()
        }
    }

    override fun DIDDetailsBlocking(
        did: String
    ): Response<DIDDetails> {
        return toBlocking {
            DIDDetails(did)
        }
    }

    override suspend fun DIDLogs(
        did: String
    ): Response<List<DIDLog>> {

        return proceed {
            HttpRequest()
                .url("$uri$did/log")
                .get()
        }
    }

    override fun DIDLogsBlocking(
        did: String
    ): Response<List<DIDLog>> {
        return toBlocking {
            DIDLogs(did)
        }
    }
}
