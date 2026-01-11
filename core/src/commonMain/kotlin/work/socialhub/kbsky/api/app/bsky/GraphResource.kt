package work.socialhub.kbsky.api.app.bsky

import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphAddUserToListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphAddUserToListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphCreateListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphCreateListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphEditListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphEditListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetBlocksRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetBlocksResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowersRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowersResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetKnownFollowersRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetKnownFollowersResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListsRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetListsResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetMutesRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetMutesResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPackRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPackResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksResponse
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphMuteActorRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphRemoveUserFromListRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphUnmuteActorRequest
import work.socialhub.kbsky.api.entity.share.Response

/**
 * Bluesky/Graph
 * [Reference](https://atproto.com/lexicons/app-bsky-graph)
 */
interface GraphResource {

    /**
     * Follow operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun follow(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse>

    fun followBlocking(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse>

    /**
     * Delete Follow operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deleteFollow(
        request: GraphDeleteFollowRequest
    ): Response<Unit>

    fun deleteFollowBlocking(
        request: GraphDeleteFollowRequest
    ): Response<Unit>

    /**
     * Who is following an actor?
     */
    suspend fun getFollowers(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse>

    fun getFollowersBlocking(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse>

    /**
     * Who is an actor following?
     */
    suspend fun getFollows(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse>

    fun getFollowsBlocking(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse>

    /**
     * Enumerates accounts which follow a specified account (actor) and are followed by the viewer.
     */
    suspend fun getKnownFollowers(
        request: GraphGetKnownFollowersRequest
    ): Response<GraphGetKnownFollowersResponse>

    fun getKnownFollowersBlocking(
        request: GraphGetKnownFollowersRequest
    ): Response<GraphGetKnownFollowersResponse>

    /**
     * Who does the viewer mute?
     */
    suspend fun getMutes(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse>

    fun getMutesBlocking(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse>

    /**
     * Mute an actor by did or handle.
     */
    suspend fun muteActor(
        request: GraphMuteActorRequest
    ): Response<Unit>

    fun muteActorBlocking(
        request: GraphMuteActorRequest
    ): Response<Unit>

    /**
     * Unmute an actor by did or handle.
     */
    suspend fun unmuteActor(
        request: GraphUnmuteActorRequest
    ): Response<Unit>

    fun unmuteActorBlocking(
        request: GraphUnmuteActorRequest
    ): Response<Unit>

    /**
     * Block operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun block(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse>

    fun blockBlocking(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse>

    /**
     * Delete Block operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deleteBlock(
        request: GraphDeleteBlockRequest
    ): Response<Unit>

    fun deleteBlockBlocking(
        request: GraphDeleteBlockRequest
    ): Response<Unit>

    /**
     * Who does the viewer mute?
     */
    suspend fun getBlocks(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse>

    fun getBlocksBlocking(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse>

    /**
     * Create a list.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun createList(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse>

    fun createListBlocking(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse>

    /**
     * Edit a list.
     * (ATProtocol/Repo getRecord and putRecord wrapper)
     */
    suspend fun editList(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse>

    fun editListBlocking(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse>

    /**
     * Delete a list.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun deleteList(
        request: GraphDeleteListRequest
    ): Response<Unit>

    fun deleteListBlocking(
        request: GraphDeleteListRequest
    ): Response<Unit>

    /**
     * Gets a 'view' (with additional context) of a specified list.
     */
    suspend fun getList(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse>

    fun getListBlocking(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse>

    /**
     * Enumerates the lists created by a specified account (actor).
     */
    suspend fun getLists(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse>

    fun getListsBlocking(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse>

    /**
     * Add a user to a list.
     * (ATProtocol/Repo createRecord wrapper)
     */
    suspend fun addUserToList(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse>

    fun addUserToListBlocking(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse>

    /**
     * Remove a user from a list.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    suspend fun removeUserFromList(
        request: GraphRemoveUserFromListRequest
    ): Response<Unit>

    fun removeUserFromListBlocking(
        request: GraphRemoveUserFromListRequest
    ): Response<Unit>

    /**
     * Gets a view of a starter pack.
     */
    suspend fun getStarterPack(
        request: GraphGetStarterPackRequest
    ): Response<GraphGetStarterPackResponse>

    fun getStarterPackBlocking(
        request: GraphGetStarterPackRequest
    ): Response<GraphGetStarterPackResponse>

    /**
     * Gets a view of a starter pack.
     */
    suspend fun getStarterPacks(
        request: GraphGetStarterPacksRequest
    ): Response<GraphGetStarterPacksResponse>

    fun getStarterPacksBlocking(
        request: GraphGetStarterPacksRequest
    ): Response<GraphGetStarterPacksResponse>
}
