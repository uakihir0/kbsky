package work.socialhub.kbsky.internal.app.bsky

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
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedCreateBookmarkRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteBookmarkRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteLikeRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeletePostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteRepostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetAuthorFeedRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetAuthorFeedResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetBookmarksRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetBookmarksResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedGeneratorRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedGeneratorResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedGeneratorsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedGeneratorsResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetLikesRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetLikesResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetListFeedRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetListFeedResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostThreadRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostThreadResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostsResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetQuotesRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetQuotesResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetRepostedByRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetRepostedByResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetTimelineRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetTimelineResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedLikeRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedLikeResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostgateRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostgateResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedRepostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedRepostResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedSearchPostsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedSearchPostsResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedThreadgateRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedThreadgateResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoDeleteRecordRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.ATUriParser
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _FeedResource(
    private val config: BlueskyConfig
) : FeedResource {

    override suspend fun getAuthorFeed(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetAuthorFeed))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getAuthorFeedBlocking(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse> {
        return toBlocking {
            getAuthorFeed(request)
        }
    }

    override suspend fun getLikes(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetLikes))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getLikesBlocking(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse> {
        return toBlocking {
            getLikes(request)
        }
    }

    override suspend fun getPostThread(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetPostThread))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getPostThreadBlocking(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse> {
        return toBlocking {
            getPostThread(request)
        }
    }

    override suspend fun getPosts(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse> {

        return proceed {
            httpRequest(config)
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

    override fun getPostsBlocking(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse> {
        return toBlocking {
            getPosts(request)
        }
    }

    override suspend fun getQuotes(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetQuotes))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getQuotesBlocking(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse> {
        return toBlocking {
            getQuotes(request)
        }
    }

    override suspend fun getRepostedBy(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetRepostedBy))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getRepostedByBlocking(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse> {
        return toBlocking {
            getRepostedBy(request)
        }
    }

    override suspend fun getTimeline(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetTimeline))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getTimelineBlocking(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse> {
        return toBlocking {
            getTimeline(request)
        }
    }

    override suspend fun getFeed(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetFeed))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getFeedBlocking(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse> {
        return toBlocking {
            getFeed(request)
        }
    }

    override suspend fun getListFeed(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetListFeed))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getListFeedBlocking(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse> {
        return toBlocking {
            getListFeed(request)
        }
    }

    override suspend fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetActorFeeds))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getActorFeedsBlocking(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse> {
        return toBlocking {
            getActorFeeds(request)
        }
    }

    override suspend fun getActorLikes(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetActorLikes))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getActorLikesBlocking(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse> {
        return toBlocking {
            getActorLikes(request)
        }
    }

    override suspend fun searchPosts(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetFeedSearchPosts))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun searchPostsBlocking(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse> {
        return toBlocking {
            searchPosts(request)
        }
    }

    override suspend fun getFeedGenerator(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetFeedGenerator))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getFeedGeneratorBlocking(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse> {
        return toBlocking {
            getFeedGenerator(request)
        }
    }

    override suspend fun getFeedGenerators(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse> {

        return proceed {
            httpRequest(config)
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

    override fun getFeedGeneratorsBlocking(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse> {
        return toBlocking {
            getFeedGenerators(request)
        }
    }

    override suspend fun like(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedLike,
                record = request.toLike(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun likeBlocking(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse> {
        return toBlocking {
            like(request)
        }
    }

    override suspend fun deleteLike(
        request: FeedDeleteLikeRequest
    ): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedLike,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deleteLikeBlocking(
        request: FeedDeleteLikeRequest
    ): ResponseUnit {
        return toBlocking {
            deleteLike(request)
        }
    }

    override suspend fun post(
        request: FeedPostRequest
    ): Response<FeedPostResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedPost,
                record = request.toPost(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun postBlocking(
        request: FeedPostRequest
    ): Response<FeedPostResponse> {
        return toBlocking {
            post(request)
        }
    }

    override suspend fun deletePost(
        request: FeedDeletePostRequest
    ): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedPost,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deletePostBlocking(
        request: FeedDeletePostRequest
    ): ResponseUnit {
        return toBlocking {
            deletePost(request)
        }
    }

    override suspend fun repost(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedRepost,
                record = request.toRepost(),
            )

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun repostBlocking(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse> {
        return toBlocking {
            repost(request)
        }
    }

    override suspend fun deleteRepost(
        request: FeedDeleteRepostRequest
    ): ResponseUnit {

        return proceedUnit {
            val record = RepoDeleteRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedRepost,
                rkey = request.rkey() ?: throw IllegalArgumentException("rkey is required"),
            )

            httpRequest(config)
                .url(xrpc(config, RepoDeleteRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deleteRepostBlocking(
        request: FeedDeleteRepostRequest
    ): ResponseUnit {
        return toBlocking {
            deleteRepost(request)
        }
    }

    override suspend fun threadgate(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedThreadgate,
                record = request.toThreadgate(),
            ).also {
                // get rkey from uri of post
                it.rkey = ATUriParser.getRKey(request.post)
            }

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun threadgateBlocking(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse> {
        return toBlocking {
            threadgate(request)
        }
    }

    override suspend fun postgate(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse> {

        return proceed {
            val record = RepoCreateRecordRequest(
                auth = request.auth,
                repo = request.auth.did,
                collection = FeedPostgate,
                record = request.toPostgate(),
            ).also {
                // get rkey from uri of post
                it.rkey = ATUriParser.getRKey(request.post)
            }

            httpRequest(config)
                .url(xrpc(config, RepoCreateRecord))
                .json(record.toMappedJson())
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun postgateBlocking(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse> {
        return toBlocking {
            postgate(request)
        }
    }

    override suspend fun createBookmark(
        request: FeedCreateBookmarkRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, FeedCreateBookmark))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun createBookmarkBlocking(
        request: FeedCreateBookmarkRequest
    ): ResponseUnit {
        return toBlocking {
            createBookmark(request)
        }
    }

    override suspend fun deleteBookmark(
        request: FeedDeleteBookmarkRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, FeedDeleteBookmark))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun deleteBookmarkBlocking(
        request: FeedDeleteBookmarkRequest
    ): ResponseUnit {
        return toBlocking {
            deleteBookmark(request)
        }
    }

    override suspend fun getBookmarks(
        request: FeedGetBookmarksRequest
    ): Response<FeedGetBookmarksResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, FeedGetBookmarks))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getBookmarksBlocking(
        request: FeedGetBookmarksRequest
    ): Response<FeedGetBookmarksResponse> {
        return toBlocking {
            getBookmarks(request)
        }
    }
}
