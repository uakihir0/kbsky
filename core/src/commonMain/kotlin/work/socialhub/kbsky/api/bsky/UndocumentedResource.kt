package work.socialhub.kbsky.api.bsky

import work.socialhub.kbsky.api.entity.bsky.undoc.UndocGetPopularRequest
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocGetPopularResponse
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocSearchFeedsRequest
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocSearchFeedsResponse
import work.socialhub.kbsky.api.entity.share.Response


interface UndocumentedResource {

    /**
     * (Undocumented endpoint)
     * Search feeds.
     */
    fun searchFeeds(
        request: UndocSearchFeedsRequest
    ): Response<List<UndocSearchFeedsResponse>>

    /**
     *
     */
    fun getPopular(
        request: UndocGetPopularRequest
    ): Response<UndocGetPopularResponse>
}
