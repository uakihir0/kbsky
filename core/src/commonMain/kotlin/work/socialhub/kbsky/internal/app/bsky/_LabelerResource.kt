package work.socialhub.kbsky.internal.app.bsky

import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.LabelerGetServices
import work.socialhub.kbsky.api.app.bsky.LabelerResource
import work.socialhub.kbsky.api.entity.app.bsky.labeler.LabelerGetServicesRequest
import work.socialhub.kbsky.api.entity.app.bsky.labeler.LabelerGetServicesResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _LabelerResource(
    private val config: BlueskyConfig
) : LabelerResource {

    override suspend fun getServices(
        request: LabelerGetServicesRequest
    ): Response<LabelerGetServicesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, LabelerGetServices))
                .accept(MediaType.JSON)
                .also { req ->
                    // dids=did1&dids=did2&...
                    request.dids.forEach {
                        req.query("dids", it)
                    }
                    request.detailed?.let {
                        req.query("detailed", it)
                    }
                }
                .getWithAuth(request.auth)
        }
    }

    override fun getServicesBlocking(
        request: LabelerGetServicesRequest
    ): Response<LabelerGetServicesResponse> = toBlocking { getServices(request) }

}
