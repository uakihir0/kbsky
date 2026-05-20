package work.socialhub.kbsky.api.app.bsky


import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularFeedGeneratorsRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularFeedGeneratorsResponse
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.share.Response
import kotlin.js.JsExport


@JsExport
interface UnspeccedResource {

    /**
     * DEPRECATED: will be removed soon. Use a feed generator alternative.
     */
    suspend fun getPopular(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse>

    @JsExport.Ignore
    fun getPopularBlocking(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse>

    /**
     * An unspecced view of globally popular feed generators.
     */
    @JsExport.Ignore
    suspend fun getPopularFeedGenerators(
        request: UnspeccedGetPopularFeedGeneratorsRequest
    ): Response<UnspeccedGetPopularFeedGeneratorsResponse>

    @JsExport.Ignore
    fun getPopularFeedGeneratorsBlocking(
        request: UnspeccedGetPopularFeedGeneratorsRequest
    ): Response<UnspeccedGetPopularFeedGeneratorsResponse>
}
