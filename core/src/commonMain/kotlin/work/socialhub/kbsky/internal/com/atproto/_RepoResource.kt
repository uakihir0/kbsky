package work.socialhub.kbsky.internal.com.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDescribeRepo
import work.socialhub.kbsky.ATProtocolTypes.RepoGetRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoListRecords
import work.socialhub.kbsky.ATProtocolTypes.RepoPutRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoUploadBlob
import work.socialhub.kbsky.api.com.atproto.RepoResource
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDescribeRepoRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDescribeRepoResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoListRecordsRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoListRecordsResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType

class _RepoResource(
    private val config: ATProtocolConfig
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
                httpRequest(config)
                    .url(xrpc(config, RepoCreateRecord))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteRecord(
        request: RepoDeleteRecordRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                httpRequest(config)
                    .url(xrpc(config, RepoDeleteRecord))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun describeRepo(
        request: RepoDescribeRepoRequest
    ): Response<RepoDescribeRepoResponse> {

        return proceed {
            runBlocking {
                httpRequest(config)
                    .url(xrpc(config, RepoDescribeRepo))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getRecord(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse> {

        return proceed {
            runBlocking {
                httpRequest(config)
                    .url(xrpc(config, RepoGetRecord))
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
                httpRequest(config)
                    .url(xrpc(config, RepoListRecords))
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
                httpRequest(config)
                    .url(xrpc(config, RepoPutRecord))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse> {

        return proceed {
            runBlocking {
                httpRequest(config)
                    .url(xrpc(config, RepoUploadBlob))
                    .header("Content-Type", request.contentType)
                    .accept(MediaType.JSON)
                    .file(
                        key = "file",
                        fileName = request.name,
                        fileBody = request.bytes
                    )
                    .postWithAuth(request.auth)
            }
        }
    }
}
