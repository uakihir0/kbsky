package work.socialhub.kbsky.internal.bsky

import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.BlueskyTypes.UnspeccedGetPopular
import work.socialhub.kbsky.api.bsky.UndocumentedResource
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocGetPopularRequest
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocGetPopularResponse
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocSearchFeedsRequest
import work.socialhub.kbsky.api.entity.bsky.undoc.UndocSearchFeedsResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _UndocumentedResource(
    private val uri: String
) : UndocumentedResource {

    override fun searchFeeds(
        request: UndocSearchFeedsRequest
    ): Response<List<UndocSearchFeedsResponse>> {

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
        request: UndocGetPopularRequest
    ): Response<UndocGetPopularResponse> {

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
