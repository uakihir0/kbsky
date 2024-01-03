package work.socialhub.kbsky.api.bsky

import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedSearchFeedsRequest
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedSearchFeedsResponse
import work.socialhub.kbsky.api.entity.share.Response


interface UnspeccedResource {

    /**
     * (Undocumented endpoint)
     * Search feeds.
     */
    fun searchFeeds(
        request: UnspeccedSearchFeedsRequest
    ): Response<List<UnspeccedSearchFeedsResponse>>

    /**
     * DEPRECATED: will be removed soon. Use a feed generator alternative.
     */
    fun getPopular(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse>
}
