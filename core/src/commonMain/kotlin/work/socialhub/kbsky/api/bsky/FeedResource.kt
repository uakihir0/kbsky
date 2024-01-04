package work.socialhub.kbsky.api.bsky

import work.socialhub.kbsky.api.entity.bsky.feed.*
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
     *
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
     * Retrieve a list of feeds created by a given actor
     */
    fun getActorFeeds(
        request: FeedGetActorFeedsRequest
    ): Response<FeedGetActorFeedsResponse>

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
}
