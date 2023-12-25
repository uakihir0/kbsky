package work.socialhub.kbsky.api.atproto

import work.socialhub.kbsky.api.entity.atproto.repo.*
import work.socialhub.kbsky.api.entity.share.Response

/**
 * ATProtocol/Repo
 * [Reference](https://atproto.com/lexicons/com-atproto-repo)
 */
interface RepoResource {

    /**
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
    fun putRecord()

    /**
     * Upload a new blob to be added to repo in a later request.
     */
    fun uploadBlob(
        request: RepoUploadBlobRequest
    ): Response<RepoUploadBlobResponse>
}
