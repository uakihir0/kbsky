package work.socialhub.kbsky.internal.app.bsky

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.RepoCreateRecord
import work.socialhub.kbsky.ATProtocolTypes.RepoDeleteRecord
import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.FeedCreateBookmark
import work.socialhub.kbsky.BlueskyTypes.FeedDeleteBookmark
import work.socialhub.kbsky.BlueskyTypes.FeedGetActorFeeds
import work.socialhub.kbsky.BlueskyTypes.FeedGetActorLikes
import work.socialhub.kbsky.BlueskyTypes.FeedGetAuthorFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetBookmarks
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedGenerator
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedGenerators
import work.socialhub.kbsky.BlueskyTypes.FeedGetFeedSearchPosts
import work.socialhub.kbsky.BlueskyTypes.FeedGetLikes
import work.socialhub.kbsky.BlueskyTypes.FeedGetListFeed
import work.socialhub.kbsky.BlueskyTypes.FeedGetPostThread
import work.socialhub.kbsky.BlueskyTypes.FeedGetPosts
import work.socialhub.kbsky.BlueskyTypes.FeedGetQuotes
import work.socialhub.kbsky.BlueskyTypes.FeedGetRepostedBy
import work.socialhub.kbsky.BlueskyTypes.FeedGetTimeline
import work.socialhub.kbsky.BlueskyTypes.FeedLike
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.BlueskyTypes.FeedPostgate
import work.socialhub.kbsky.BlueskyTypes.FeedRepost
import work.socialhub.kbsky.BlueskyTypes.FeedThreadgate
import work.socialhub.kbsky.api.app.bsky.FeedResource
import work.socialhub.kbsky.api.entity.app.bsky.feed.*
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _FeedResource(
    private val config: BlueskyConfig
) : FeedResource {

    override fun getAuthorFeed(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetAuthorFeed))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getLikes(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetLikes))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getPostThread(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetPostThread))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getPosts(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetPosts))
                    .accept(MediaType.JSON)
                    .also { req ->
                        request.uris?.forEach {
                            req.query("uris", it)
                        }
                    }
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getQuotes(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetQuotes))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getRepostedBy(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetRepostedBy))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getTimeline(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetTimeline))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getFeed(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetFeed))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getListFeed(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetListFeed))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetActorFeeds))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getActorLikes(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetActorLikes))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun searchPosts(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetFeedSearchPosts))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getFeedGenerator(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetFeedGenerator))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun getFeedGenerators(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetFeedGenerators))
                    .accept(MediaType.JSON)
                    .also { req ->
                        request.feeds?.forEach {
                            req.query("feeds", it)
                        }
                    }
                    .getWithAuth(request.auth)
            }
        }
    }

    override fun like(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedLike,
                    record = request.toLike(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteLike(
        request: FeedDeleteLikeRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedLike,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun post(
        request: FeedPostRequest
    ): Response<FeedPostResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedPost,
                    record = request.toPost(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deletePost(
        request: FeedDeletePostRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedPost,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun repost(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedRepost,
                    record = request.toRepost(),
                )

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteRepost(
        request: FeedDeleteRepostRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                val record = RepoDeleteRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedRepost,
                    rkey = request.rkey()!!,
                )

                HttpRequest()
                    .url(xrpc(config, RepoDeleteRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun threadgate(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedThreadgate,
                    record = request.toThreadgate(),
                ).also {
                    // get rkey from uri of post
                    it.rkey = ATUriParser.getRKey(request.post)
                }

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun postgate(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse> {

        return proceed {
            runBlocking {
                val record = RepoCreateRecordRequest(
                    auth = request.auth,
                    repo = request.auth.did,
                    collection = FeedPostgate,
                    record = request.toPostgate(),
                ).also {
                    // get rkey from uri of post
                    it.rkey = ATUriParser.getRKey(request.post)
                }

                HttpRequest()
                    .url(xrpc(config, RepoCreateRecord))
                    .json(record.toMappedJson())
                    .accept(MediaType.JSON)
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun createBookmark(
        request: FeedCreateBookmarkRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedCreateBookmark))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun deleteBookmark(
        request: FeedDeleteBookmarkRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedDeleteBookmark))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .postWithAuth(request.auth)
            }
        }
    }

    override fun getBookmarks(
        request: FeedGetBookmarksRequest
    ): Response<FeedGetBookmarksResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, FeedGetBookmarks))
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .getWithAuth(request.auth)
            }
        }
    }
}
