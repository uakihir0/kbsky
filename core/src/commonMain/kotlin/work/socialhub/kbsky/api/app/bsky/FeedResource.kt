package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedCreateBookmarkRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteLikeRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeletePostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteRepostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesResponse
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetAuthorFeedRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetAuthorFeedResponse
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

/**
 * Bluesky/Feed
 * [Reference](https://atproto.com/lexicons/app-bsky-feed)
 */
interface FeedResource {

    /**
     * A view of a user's feed.
     */
    fun getAuthorFeed(
        request: FeedGetAuthorFeedRequest
    ): Response<FeedGetAuthorFeedResponse>

    /**
     *
     */
    fun getLikes(
        request: FeedGetLikesRequest
    ): Response<FeedGetLikesResponse>

    /**
     *
     */
    fun getPostThread(
        request: FeedGetPostThreadRequest
    ): Response<FeedGetPostThreadResponse>

    /**
     * A view of an actor's feed.
     */
    fun getPosts(
        request: FeedGetPostsRequest
    ): Response<FeedGetPostsResponse>

    /**
     * Get a list of quotes for a given post.
     */
    fun getQuotes(
        request: FeedGetQuotesRequest
    ): Response<FeedGetQuotesResponse>

    /**
     * Get a list of reposts for a given post.
     */
    fun getRepostedBy(
        request: FeedGetRepostedByRequest
    ): Response<FeedGetRepostedByResponse>

    /**
     * A view of the user's home timeline.
     */
    fun getTimeline(
        request: FeedGetTimelineRequest
    ): Response<FeedGetTimelineResponse>

    /**
     * Compose and hydrate a feed from a user's selected feed generator.
     */
    fun getFeed(
        request: FeedGetFeedRequest
    ): Response<FeedGetFeedResponse>

    /**
     * Get a feed of recent posts from a list (posts and reposts from any actors on the list). Does not require auth.
     */
    fun getListFeed(
        request: FeedGetListFeedRequest
    ): Response<FeedGetListFeedResponse>

    /**
     * Retrieve a list of feeds created by a given actor
     */
    fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse>

    /**
     * Get a list of posts liked by an actor.
     */
    fun getActorLikes(
        request: FeedGetActorLikesRequest
    ): Response<FeedGetActorLikesResponse>

    /**
     * Find posts matching search criteria.
     */
    fun searchPosts(
        request: FeedSearchPostsRequest
    ): Response<FeedSearchPostsResponse>

    /**
     * Get information about a specific feed offered by a feed generator, such as its online status.
     */
    fun getFeedGenerator(
        request: FeedGetFeedGeneratorRequest
    ): Response<FeedGetFeedGeneratorResponse>

    /**
     * Get information about a list of feed generators.
     */
    fun getFeedGenerators(
        request: FeedGetFeedGeneratorsRequest
    ): Response<FeedGetFeedGeneratorsResponse>

    /**
     * Like feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun like(
        request: FeedLikeRequest
    ): Response<FeedLikeResponse>

    /**
     * Delete Like operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun deleteLike(
        request: FeedDeleteLikeRequest
    ): Response<Unit>

    /**
     * Post feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun post(
        request: FeedPostRequest
    ): Response<FeedPostResponse>

    /**
     * Delete Feed operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun deletePost(
        request: FeedDeletePostRequest
    ): Response<Unit>

    /**
     * Repost feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun repost(
        request: FeedRepostRequest
    ): Response<FeedRepostResponse>

    /**
     * Delete Repost operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun deleteRepost(
        request: FeedDeleteRepostRequest
    ): Response<Unit>

    /**
     * Threadgate feed operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun threadgate(
        request: FeedThreadgateRequest
    ): Response<FeedThreadgateResponse>

    /**
     * Record defining interaction rules for a post.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun postgate(
        request: FeedPostgateRequest
    ): Response<FeedPostgateResponse>

    /**
     * Creates a private bookmark for the specified record.
     */
    fun createBookmark(
        request: FeedCreateBookmarkRequest
    ): Response<Unit>
}
