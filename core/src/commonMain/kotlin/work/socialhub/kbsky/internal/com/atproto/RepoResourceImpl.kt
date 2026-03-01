package work.socialhub.kbsky.internal.com.atproto

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
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class RepoResourceImpl(
    private val config: ATProtocolConfig
) : RepoResource {

    // TODO: implement
    override fun applyWrites() {
        throw IllegalStateException("not implemented.")
    }

    override suspend fun createRecord(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun createRecordBlocking(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse> = toBlocking { createRecord(request) }

    override suspend fun deleteRecord(
        request: RepoDeleteRecordRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun deleteRecordBlocking(
        request: RepoDeleteRecordRequest
    ): ResponseUnit = toBlocking { deleteRecord(request) }

    override suspend fun describeRepo(
        request: RepoDescribeRepoRequest
    ): Response<RepoDescribeRepoResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, RepoDescribeRepo))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .get()
        }
    }

    override fun describeRepoBlocking(
        request: RepoDescribeRepoRequest
    ): Response<RepoDescribeRepoResponse> = toBlocking { describeRepo(request) }

    override suspend fun getRecord(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, RepoGetRecord))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .get()
        }
    }

    override fun getRecordBlocking(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse> = toBlocking { getRecord(request) }

    override suspend fun listRecords(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, RepoListRecords))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .get()
        }
    }

    override fun listRecordsBlocking(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse> = toBlocking { listRecords(request) }

    override suspend fun putRecord(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, RepoPutRecord))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun putRecordBlocking(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse> = toBlocking { putRecord(request) }

    override suspend fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse> {

        return proceed {
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

    override fun uploadBlobBlocking(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse> = toBlocking { uploadBlob(request) }
}
