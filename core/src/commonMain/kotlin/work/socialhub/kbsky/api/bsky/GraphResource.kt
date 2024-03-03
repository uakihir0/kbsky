package work.socialhub.kbsky.api.bsky

import work.socialhub.kbsky.api.entity.bsky.graph.*
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
    fun follow(
        request: GraphFollowRequest
    ): Response<GraphFollowResponse>

    /**
     * Delete Follow operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun deleteFollow(
        request: GraphDeleteFollowRequest
    ): Response<Unit>

    /**
     * Who is following an actor?
     */
    fun getFollowers(
        request: GraphGetFollowersRequest
    ): Response<GraphGetFollowersResponse>

    /**
     * Who is an actor following?
     */
    fun getFollows(
        request: GraphGetFollowsRequest
    ): Response<GraphGetFollowsResponse>

    /**
     * Who does the viewer mute?
     */
    fun getMutes(
        request: GraphGetMutesRequest
    ): Response<GraphGetMutesResponse>

    /**
     * Mute an actor by did or handle.
     */
    fun muteActor(
        request: GraphMuteActorRequest
    ): Response<Unit>

    /**
     * Unmute an actor by did or handle.
     */
    fun unmuteActor(
        request: GraphUnmuteActorRequest
    ): Response<Unit>

    /**
     * Block operation.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun block(
        request: GraphBlockRequest
    ): Response<GraphBlockResponse>

    /**
     * Delete Block operation.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun deleteBlock(
        request: GraphDeleteBlockRequest
    ): Response<Unit>

    /**
     * Who does the viewer mute?
     */
    fun getBlocks(
        request: GraphGetBlocksRequest
    ): Response<GraphGetBlocksResponse>

    /**
     * Create a list.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun createList(
        request: GraphCreateListRequest
    ): Response<GraphCreateListResponse>

    /**
     * Edit a list.
     * (ATProtocol/Repo getRecord and putRecord wrapper)
     */
    fun editList(
        request: GraphEditListRequest
    ): Response<GraphEditListResponse>

    /**
     * Gets a 'view' (with additional context) of a specified list.
     */
    fun getList(
        request: GraphGetListRequest
    ): Response<GraphGetListResponse>

    /**
     * Enumerates the lists created by a specified account (actor).
     */
    fun getLists(
        request: GraphGetListsRequest
    ): Response<GraphGetListsResponse>

    /**
     * Add a user to a list.
     * (ATProtocol/Repo createRecord wrapper)
     */
    fun addUserToList(
        request: GraphAddUserToListRequest
    ): Response<GraphAddUserToListResponse>

    /**
     * Remove a user from a list.
     * (ATProtocol/Repo deleteRecord wrapper)
     */
    fun removeUserFromList(
        request: GraphRemoveUserFromListRequest
    ): Response<Unit>

}
