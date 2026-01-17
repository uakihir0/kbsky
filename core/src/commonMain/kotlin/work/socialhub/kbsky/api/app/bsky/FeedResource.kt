package work.socialhub.kbsky.api.app.bsky


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
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import kotlin.js.JsExport

/**
 * Bluesky/Feed
 * [Reference](https://atproto.com/lexicons/app-bsky-feed)
 */
@JsExport
interface FeedResource {

    /**
     * A view of a user's feed.
     */
    suspend fun getAuthorFeed(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse>

    @JsExport.Ignore
    fun getAuthorFeedBlocking(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse>

    /**
     *
     */
    suspend fun getLikes(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse>

    @JsExport.Ignore
    fun getLikesBlocking(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse>

    /**
     *
     */
    suspend fun getPostThread(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse>

    @JsExport.Ignore
    fun getPostThreadBlocking(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse>

    /**
     * A view of an actor's feed.
     */
    suspend fun getPosts(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse>

    @JsExport.Ignore
    fun getPostsBlocking(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse>

    /**
     * Get a list of quotes for a given post.
     */
    suspend fun getQuotes(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse>

    @JsExport.Ignore
    fun getQuotesBlocking(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse>

    /**
     * Get a list of reposts for a given post.
     */
    suspend fun getRepostedBy(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse>

    @JsExport.Ignore
    fun getRepostedByBlocking(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse>

    /**
     * A view of the user's home timeline.
     */
    suspend fun getTimeline(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse>

    @JsExport.Ignore
    fun getTimelineBlocking(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse>

    /**
     * Compose and hydrate a feed from a user's selected feed generator.
     */
    suspend fun getFeed(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse>

    @JsExport.Ignore
    fun getFeedBlocking(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse>

    /**
     * Get a feed of recent posts from a list (posts and reposts from any actors on the list). Does not require auth.
     */
    suspend fun getListFeed(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse>

    @JsExport.Ignore
    fun getListFeedBlocking(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse>

    /**
     * Retrieve a list of feeds created by a given actor
     */
    suspend fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse>

    @JsExport.Ignore
    fun getActorFeedsBlocking(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse>

    /**
     * Get a list of posts liked by an actor.
     */
    suspend fun getActorLikes(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse>

    @JsExport.Ignore
    fun getActorLikesBlocking(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse>

    /**
     * Find posts matching search criteria.
     */
    suspend fun searchPosts(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse>

    @JsExport.Ignore
    fun searchPostsBlocking(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse>

    /**
     * Get information about a specific feed offered by a feed generator, such as its online status.
     */
    suspend fun getFeedGenerator(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse>

    @JsExport.Ignore
    fun getFeedGeneratorBlocking(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse>

    /**
     * Get information about a list of feed generators.
     */
    suspend fun getFeedGenerators(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse>

    @JsExport.Ignore
    fun getFeedGeneratorsBlocking(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse>

    /**
     * Like feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun like(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse>

    @JsExport.Ignore
    fun likeBlocking(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse>

    /**
     * Delete Like operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deleteLike(
        request: FeedDeleteLikeRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteLikeBlocking(
        request: FeedDeleteLikeRequest
    ): ResponseUnit

    /**
     * Post feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun post(
        request: FeedPostRequest
    ): Response<FeedPostResponse>

    @JsExport.Ignore
    fun postBlocking(
        request: FeedPostRequest
    ): Response<FeedPostResponse>

    /**
     * Delete Feed operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deletePost(
        request: FeedDeletePostRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deletePostBlocking(
        request: FeedDeletePostRequest
    ): ResponseUnit

    /**
     * Repost feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun repost(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse>

    @JsExport.Ignore
    fun repostBlocking(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse>

    /**
     * Delete Repost operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deleteRepost(
        request: FeedDeleteRepostRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteRepostBlocking(
        request: FeedDeleteRepostRequest
    ): ResponseUnit

    /**
     * Threadgate feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun threadgate(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse>

    @JsExport.Ignore
    fun threadgateBlocking(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse>

    /**
     * Record defining interaction rules for a post.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun postgate(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse>

    @JsExport.Ignore
    fun postgateBlocking(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse>

    /**
     * Creates a private bookmark for the specified record.
     */
    suspend fun createBookmark(
        request: FeedCreateBookmarkRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun createBookmarkBlocking(
        request: FeedCreateBookmarkRequest
    ): ResponseUnit

    /**
     * Deletes a private bookmark for the specified record.
     */
    suspend fun deleteBookmark(
        request: FeedDeleteBookmarkRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteBookmarkBlocking(
        request: FeedDeleteBookmarkRequest
    ): ResponseUnit

    /**
     * Gets views of records bookmarked by the authenticated user.
     */
    suspend fun getBookmarks(
        request: FeedGetBookmarksRequest
    ): Response<FeedGetBookmarksResponse>

    @JsExport.Ignore
    fun getBookmarksBlocking(
        request: FeedGetBookmarksRequest
    ): Response<FeedGetBookmarksResponse>
}
