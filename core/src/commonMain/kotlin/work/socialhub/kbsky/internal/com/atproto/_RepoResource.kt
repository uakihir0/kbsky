package work.socialhub.kbsky.internal.com.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoGetRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoListRecords
import work.socialhub.kbsky.ATProtocolTypes.RepoPutRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoUploadBlob
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.entity.com.atproto.repo.*
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _RepoResource(
    private val uri: String
) : RepoResource {

    // TODO: implement
    override fun applyWrites() {
        throw IllegalStateException("not implemented.")
    }

    override fun createRecord(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
    }

    override fun deleteRecord(
        request: RepoDeleteRecordRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
    }

    override fun describeRepo() {
        throw IllegalStateException("not implemented.")
    }

    override fun getRecord(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoGetRecord))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun listRecords(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoListRecords))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun putRecord(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoPutRecord))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
    }

    override fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, RepoUploadBlob))
                    .header("Authorization", request.bearerToken)
                    .header("Content-Type", "image/jpeg")
                    .accept(MediaType.JSON)
                    .file(
                        key = "file",
                        fileName = request.name,
                        fileBody = request.bytes
                    )
                    .post()
            }
        }
    }
}
