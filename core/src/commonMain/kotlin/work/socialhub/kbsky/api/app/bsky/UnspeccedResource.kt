package work.socialhub.kbsky.api.app.bsky


import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularFeedGeneratorsRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularFeedGeneratorsResponse
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPostThreadV2Request
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPostThreadV2Response
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

    /**
     * (NOTE: this endpoint is under development and WILL change without notice. Inputs and outputs are not stable.) Get posts in a thread. It is based in an anchor post at any depth of the tree, and returns posts above it (recursively resolving the parent, without further branching to their replies) and below it (recursive resolution of the replies, branching to their replies). Does not require auth, but additional metadata and filtering will be applied for authed requests.
     */
    @JsExport.Ignore
    suspend fun getPostThreadV2(
        request: UnspeccedGetPostThreadV2Request
    ): Response<UnspeccedGetPostThreadV2Response>

    @JsExport.Ignore
    fun getPostThreadV2Blocking(
        request: UnspeccedGetPostThreadV2Request
    ): Response<UnspeccedGetPostThreadV2Response>
}
