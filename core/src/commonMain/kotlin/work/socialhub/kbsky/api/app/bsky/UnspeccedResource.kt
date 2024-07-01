package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.share.Response


interface UnspeccedResource {

    /**
     * DEPRECATED: will be removed soon. Use a feed generator alternative.
     */
    fun getPopular(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse>
}
