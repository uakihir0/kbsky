package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.labeler.LabelerGetServicesRequest
import work.socialhub.kbsky.api.entity.app.bsky.labeler.LabelerGetServicesResponse
import work.socialhub.kbsky.api.entity.share.Response

/**
 * Bluesky/Labeler
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/app/bsky/labeler)
 */
interface LabelerResource {

    /**
     * Get information about a list of labeler services.
     */
    suspend fun getServices(
        request: LabelerGetServicesRequest
    ): Response<LabelerGetServicesResponse>

    fun getServicesBlocking(
        request: LabelerGetServicesRequest
    ): Response<LabelerGetServicesResponse>
}