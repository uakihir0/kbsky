package work.socialhub.kbsky.internal.app.bsky

import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.UnspeccedGetPopular
import work.socialhub.kbsky.api.app.bsky.UnspeccedResource
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _UnspeccedResource(
    private val config: BlueskyConfig
) : UnspeccedResource {

    override suspend fun getPopular(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, UnspeccedGetPopular))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getPopularBlocking(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse> = toBlocking { getPopular(request) }
}
