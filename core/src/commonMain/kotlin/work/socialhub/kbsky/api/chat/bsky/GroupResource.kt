package work.socialhub.kbsky.api.chat.bsky


import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupAddMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupAddMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupApproveJoinRequestRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupApproveJoinRequestResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateGroupRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateGroupResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupCreateJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupDisableJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupDisableJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditGroupRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditGroupResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEditJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEnableJoinLinkRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupEnableJoinLinkResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupGetJoinLinkPreviewsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupGetJoinLinkPreviewsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListJoinRequestsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListJoinRequestsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListMutualGroupsRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupListMutualGroupsResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRejectJoinRequestRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRemoveMembersRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRemoveMembersResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRequestJoinRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupRequestJoinResponse
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupUpdateJoinRequestsReadRequest
import work.socialhub.kbsky.api.entity.chat.bsky.group.GroupWithdrawJoinRequestRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import kotlin.js.JsExport

/**
 * Chat/Bluesky/Group
 *
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/chat/bsky/group)
 */
@JsExport
interface GroupResource {

    /**
     * chat.bsky.group.createGroup
     */
    suspend fun createGroup(
        request: GroupCreateGroupRequest
    ): Response<GroupCreateGroupResponse>

    @JsExport.Ignore
    fun createGroupBlocking(
        request: GroupCreateGroupRequest
    ): Response<GroupCreateGroupResponse>

    /**
     * chat.bsky.group.addMembers
     */
    suspend fun addMembers(
        request: GroupAddMembersRequest
    ): Response<GroupAddMembersResponse>

    @JsExport.Ignore
    fun addMembersBlocking(
        request: GroupAddMembersRequest
    ): Response<GroupAddMembersResponse>

    /**
     * chat.bsky.group.removeMembers
     */
    suspend fun removeMembers(
        request: GroupRemoveMembersRequest
    ): Response<GroupRemoveMembersResponse>

    @JsExport.Ignore
    fun removeMembersBlocking(
        request: GroupRemoveMembersRequest
    ): Response<GroupRemoveMembersResponse>

    /**
     * chat.bsky.group.editGroup
     */
    suspend fun editGroup(
        request: GroupEditGroupRequest
    ): Response<GroupEditGroupResponse>

    @JsExport.Ignore
    fun editGroupBlocking(
        request: GroupEditGroupRequest
    ): Response<GroupEditGroupResponse>

    /**
     * chat.bsky.group.requestJoin
     */
    suspend fun requestJoin(
        request: GroupRequestJoinRequest
    ): Response<GroupRequestJoinResponse>

    @JsExport.Ignore
    fun requestJoinBlocking(
        request: GroupRequestJoinRequest
    ): Response<GroupRequestJoinResponse>

    /**
     * chat.bsky.group.withdrawJoinRequest
     */
    suspend fun withdrawJoinRequest(
        request: GroupWithdrawJoinRequestRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun withdrawJoinRequestBlocking(
        request: GroupWithdrawJoinRequestRequest
    ): ResponseUnit

    /**
     * chat.bsky.group.listJoinRequests
     */
    suspend fun listJoinRequests(
        request: GroupListJoinRequestsRequest
    ): Response<GroupListJoinRequestsResponse>

    @JsExport.Ignore
    fun listJoinRequestsBlocking(
        request: GroupListJoinRequestsRequest
    ): Response<GroupListJoinRequestsResponse>

    /**
     * chat.bsky.group.approveJoinRequest
     */
    suspend fun approveJoinRequest(
        request: GroupApproveJoinRequestRequest
    ): Response<GroupApproveJoinRequestResponse>

    @JsExport.Ignore
    fun approveJoinRequestBlocking(
        request: GroupApproveJoinRequestRequest
    ): Response<GroupApproveJoinRequestResponse>

    /**
     * chat.bsky.group.rejectJoinRequest
     */
    suspend fun rejectJoinRequest(
        request: GroupRejectJoinRequestRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun rejectJoinRequestBlocking(
        request: GroupRejectJoinRequestRequest
    ): ResponseUnit

    /**
     * chat.bsky.group.updateJoinRequestsRead
     */
    suspend fun updateJoinRequestsRead(
        request: GroupUpdateJoinRequestsReadRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun updateJoinRequestsReadBlocking(
        request: GroupUpdateJoinRequestsReadRequest
    ): ResponseUnit

    /**
     * chat.bsky.group.createJoinLink
     */
    suspend fun createJoinLink(
        request: GroupCreateJoinLinkRequest
    ): Response<GroupCreateJoinLinkResponse>

    @JsExport.Ignore
    fun createJoinLinkBlocking(
        request: GroupCreateJoinLinkRequest
    ): Response<GroupCreateJoinLinkResponse>

    /**
     * chat.bsky.group.editJoinLink
     */
    suspend fun editJoinLink(
        request: GroupEditJoinLinkRequest
    ): Response<GroupEditJoinLinkResponse>

    @JsExport.Ignore
    fun editJoinLinkBlocking(
        request: GroupEditJoinLinkRequest
    ): Response<GroupEditJoinLinkResponse>

    /**
     * chat.bsky.group.enableJoinLink
     */
    suspend fun enableJoinLink(
        request: GroupEnableJoinLinkRequest
    ): Response<GroupEnableJoinLinkResponse>

    @JsExport.Ignore
    fun enableJoinLinkBlocking(
        request: GroupEnableJoinLinkRequest
    ): Response<GroupEnableJoinLinkResponse>

    /**
     * chat.bsky.group.disableJoinLink
     */
    suspend fun disableJoinLink(
        request: GroupDisableJoinLinkRequest
    ): Response<GroupDisableJoinLinkResponse>

    @JsExport.Ignore
    fun disableJoinLinkBlocking(
        request: GroupDisableJoinLinkRequest
    ): Response<GroupDisableJoinLinkResponse>

    /**
     * chat.bsky.group.getJoinLinkPreviews
     */
    suspend fun getJoinLinkPreviews(
        request: GroupGetJoinLinkPreviewsRequest
    ): Response<GroupGetJoinLinkPreviewsResponse>

    @JsExport.Ignore
    fun getJoinLinkPreviewsBlocking(
        request: GroupGetJoinLinkPreviewsRequest
    ): Response<GroupGetJoinLinkPreviewsResponse>

    /**
     * chat.bsky.group.listMutualGroups
     */
    suspend fun listMutualGroups(
        request: GroupListMutualGroupsRequest
    ): Response<GroupListMutualGroupsResponse>

    @JsExport.Ignore
    fun listMutualGroupsBlocking(
        request: GroupListMutualGroupsRequest
    ): Response<GroupListMutualGroupsResponse>
}
