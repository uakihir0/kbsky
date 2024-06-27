package work.socialhub.kbsky.internal.app.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.BlueskyTypes.FeedGetActorFeeds
import work.socialhub.kbsky.BlueskyTypes.FeedGetActorLikes
import work.socialhub.kbsky.BlueskyTypes.FeedGetAuthorFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedGenerator
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedGenerators
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedSearchPosts
import work.socialhub.kbsky.BlueskyTypes.FeedGetLikes
import work.socialhub.kbsky.BlueskyTypes.FeedGetListFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetPostThread
import work.socialhub.kbsky.BlueskyTypes.FeedGetPosts
import work.socialhub.kbsky.BlueskyTypes.FeedGetRepostedBy
import work.socialhub.kbsky.BlueskyTypes.FeedGetTimeline
import work.socialhub.kbsky.BlueskyTypes.FeedLike
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.BlueskyTypes.FeedRepost
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedThreadgateRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedThreadgateResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.bsky.feed.*
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _FeedResource(
    private val uri: String
) : FeedResource {

    override fun getAuthorFeed(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetAuthorFeed))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getLikes(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetLikes))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getPostThread(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetPostThread))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getPosts(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetPosts))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .also { req ->
                        request.uris?.forEach {
                            req.query("uris", it)
                        }
                    }
                    .get()
            }
        }
    }

    override fun getRepostedBy(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetRepostedBy))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getTimeline(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetTimeline))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getFeed(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetFeed))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getListFeed(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetListFeed))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetActorFeeds))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getActorLikes(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetActorLikes))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun searchPosts(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetFeedSearchPosts))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getFeedGenerator(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetFeedGenerator))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getFeedGenerators(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(uri, FeedGetFeedGenerators))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .also { req ->
                        request.feeds?.forEach {
                            req.query("feeds", it)
                        }
                    }
                    .get()
            }
        }
    }

    override fun like(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedLike,
                    record = request.toLike(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun deleteLike(
        request: FeedDeleteLikeRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedLike,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun post(
        request: FeedPostRequest
    ): Response<FeedPostResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedPost,
                    record = request.toPost(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun deletePost(
        request: FeedDeletePostRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedPost,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun repost(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedRepost,
                    record = request.toRepost(),
                )

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun deleteRepost(
        request: FeedDeleteRepostRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = FeedRepost,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(uri, RepoDeleteRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun threadgate(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    accessJwt = request.accessJwt,
                    repo = request.did!!,
                    collection = BlueskyTypes.FeedThreadgate,
                    record = request.toThreadgate(),
                ).also {
                    // get rkey from uri of post
                    it.rkey = ATUriParser.getRKey(request.post)
                }

                HttpRequest()
                    .url(xrpc(uri, RepoCreateRecord))
                    .header("Authorization", request.bearerToken)
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }
}
