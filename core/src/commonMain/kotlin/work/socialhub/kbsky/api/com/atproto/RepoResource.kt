package work.socialhub.kbsky.api.com.atproto

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
import kotlin.js.JsExport

/**
 * ATProtocol/Repo
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/repo)
 */
@JsExport
interface RepoResource {

    /**
     * TODO:
     * Apply a batch transaction of creates, updates, and deletes.
     */
    fun applyWrites()

    /**
     * Create a new record.
     */
    suspend fun createRecord(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse>

    @JsExport.Ignore
    fun createRecordBlocking(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse>

    /**
     * Delete a record, or ensure it doesn't exist.
     */
    suspend fun deleteRecord(
        request: RepoDeleteRecordRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteRecordBlocking(
        request: RepoDeleteRecordRequest
    ): ResponseUnit

    /**
     * Get information about an account and repository, including the list of collections. Does not require auth.
     */
    suspend fun describeRepo(
        request: RepoDescribeRepoRequest
    ): Response<RepoDescribeRepoResponse>

    @JsExport.Ignore
    fun describeRepoBlocking(
        request: RepoDescribeRepoRequest
    ): Response<RepoDescribeRepoResponse>

    /**
     * Get a record.
     */
    suspend fun getRecord(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse>

    @JsExport.Ignore
    fun getRecordBlocking(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse>

    /**
     * List a range of records in a collection.
     */
    suspend fun listRecords(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse>

    @JsExport.Ignore
    fun listRecordsBlocking(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse>

    /**
     * Write a record, creating or updating it as needed.
     */
    suspend fun putRecord(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse>

    @JsExport.Ignore
    fun putRecordBlocking(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse>

    /**
     * Upload a new blob to be added to repo in a later request.
     */
    suspend fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse>

    @JsExport.Ignore
    fun uploadBlobBlocking(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse>
}
