package work.socialhub.kbsky.internal.bsky

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.BlueskyTypes.UnspeccedGetPopular
import work.socialhub.kbsky.api.bsky.UnspeccedResource
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedGetPopularRequest
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedGetPopularResponse
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedSearchFeedsRequest
import work.socialhub.kbsky.api.entity.bsky.unspecced.UnspeccedSearchFeedsResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _UnspeccedResource(
    private val uri: String
) : UnspeccedResource {

    override fun searchFeeds(
        request: UnspeccedSearchFeedsRequest
    ): Response<List<UnspeccedSearchFeedsResponse>> {

        return proceed {
            runBlocking {
                // TODO: エンドポイントを外部指定可能に変更
                val url = Url(uri)
                val target: String =
                    url.protocol.name +
                            "://search." +
                            url.host +
                            "/search/"

                HttpRequest()
                    .url(target)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getPopular(
        request: UnspeccedGetPopularRequest
    ): Response<UnspeccedGetPopularResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, UnspeccedGetPopular))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }
}
