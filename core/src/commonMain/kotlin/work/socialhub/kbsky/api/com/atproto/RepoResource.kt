package work.socialhub.kbsky.api.com.atproto

import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoListRecordsRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoListRecordsResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoPutRecordResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobResponse
import work.socialhub.kbsky.api.entity.share.Response

/**
 * ATProtocol/Repo
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/repo)
 */
interface RepoResource {

    /**
     * TODO:
     * Apply a batch transaction of creates, updates, and deletes.
     */
    fun applyWrites()

    /**
     * Create a new record.
     */
    fun createRecord(
        request: RepoCreateRecordRequest
    ): Response<RepoCreateRecordResponse>

    /**
     * Delete a record, or ensure it doesn't exist.
     */
    fun deleteRecord(
        request: RepoDeleteRecordRequest
    ): Response<Unit>

    /**
     * TODO:
     * Get information about the repo, including the list of collections.
     */
    fun describeRepo()

    /**
     * Get a record.
     */
    fun getRecord(
        request: RepoGetRecordRequest
    ): Response<RepoGetRecordResponse>

    /**
     * List a range of records in a collection.
     */
    fun listRecords(
        request: RepoListRecordsRequest
    ): Response<RepoListRecordsResponse>

    /**
     * Write a record, creating or updating it as needed.
     */
    fun putRecord(
        request: RepoPutRecordRequest
    ): Response<RepoPutRecordResponse>

    /**
     * Upload a new blob to be added to repo in a later request.
     */
    fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse>
}
